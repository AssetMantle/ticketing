package models.analytics

import models.master._
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._
import utilities.MicroNumber

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class NFTAnalysis(id: String, collectionId: String, totalSold: Long, totalTraded: Long, totalListed: BigInt, totalVolumeTraded: MicroNumber, bestOffer: MicroNumber, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity[String] with Logging {

  def serialize: NFTsAnalysis.NFTAnalysisSerialized = NFTsAnalysis.NFTAnalysisSerialized(
    id = this.id,
    collectionId = this.collectionId,
    totalSold = this.totalSold,
    totalTraded = this.totalTraded,
    totalListed = BigDecimal(this.totalListed),
    totalVolumeTraded = this.totalVolumeTraded.toBigDecimal,
    bestOffer = this.bestOffer.toBigDecimal,
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch
  )

}

private[analytics] object NFTsAnalysis {

  case class NFTAnalysisSerialized(id: String, collectionId: String, totalSold: Long, totalTraded: Long, totalListed: BigDecimal, totalVolumeTraded: BigDecimal, bestOffer: BigDecimal, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity[String] with Logging {

    def deserialize()(implicit module: String, logger: Logger): NFTAnalysis = NFTAnalysis(
      id = this.id,
      collectionId = this.collectionId,
      totalSold = this.totalSold,
      totalTraded = this.totalTraded,
      totalListed = this.totalListed.toBigInt,
      totalVolumeTraded = MicroNumber(this.totalVolumeTraded),
      bestOffer = MicroNumber(this.bestOffer),
      createdBy = this.createdBy,
      createdOnMillisEpoch = this.createdOnMillisEpoch,
      updatedBy = this.updatedBy,
      updatedOnMillisEpoch = this.updatedOnMillisEpoch
    )

  }

  class NFTAnalysisTable(tag: Tag) extends Table[NFTAnalysisSerialized](tag, "NFTAnalysis") with ModelTable[String] {

    def * = (id, collectionId, totalSold, totalTraded, totalListed, totalVolumeTraded, bestOffer, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (NFTAnalysisSerialized.tupled, NFTAnalysisSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def collectionId = column[String]("collectionId")

    def totalSold = column[Long]("totalSold")

    def totalTraded = column[Long]("totalTraded")

    def totalListed = column[BigDecimal]("totalListed")

    def totalVolumeTraded = column[BigDecimal]("totalVolumeTraded")

    def bestOffer = column[BigDecimal]("bestOffer")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

  }
}

@Singleton
class NFTsAnalysis @Inject()(
                              masterNFTs: NFTs,
                              masterSecondaryMarkets: SecondaryMarkets,
                              protected val dbConfigProvider: DatabaseConfigProvider,
                            )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[NFTsAnalysis.NFTAnalysisTable, NFTsAnalysis.NFTAnalysisSerialized, String]() {

  implicit val module: String = constants.Module.ANALYTICS_COLLECTION

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new NFTsAnalysis.NFTAnalysisTable(tag))

  object Service {

    def add(nftAnalysis: NFTAnalysis): Future[String] = create(nftAnalysis.serialize).map(_.id)

    def add(nftsAnalysis: Seq[NFTAnalysis]): Future[Int] = create(nftsAnalysis.map(_.serialize))

    def tryGet(id: String): Future[NFTAnalysis] = filterHead(_.id === id).map(_.deserialize)

    def update(nftAnalysis: NFTAnalysis): Future[Unit] = updateById(nftAnalysis.serialize)

    def delete(ids: Seq[String]): Future[Int] = filterAndDelete(_.id.inSet(ids))
  }

  object Utility {

    def onNewNFT(id: String, collectionId: String): Future[String] = Service.add(NFTAnalysis(id = id, collectionId = collectionId, totalSold = 0, totalTraded = 0, totalVolumeTraded = 0, bestOffer = 0, totalListed = 0))

    def onCreateSecondaryMarket(nftId: String, totalListed: Int, listingPrice: MicroNumber): Future[Unit] = {
      val nftAnalysis = Service.tryGet(nftId)

      def update(nftAnalysis: NFTAnalysis) = {
        val newBestOffer = if (nftAnalysis.bestOffer > MicroNumber.zero) Seq(listingPrice, nftAnalysis.bestOffer).min else listingPrice
        Service.update(nftAnalysis.copy(totalListed = nftAnalysis.totalListed + totalListed, bestOffer = newBestOffer))
      }

      for {
        nftAnalysis <- nftAnalysis
        _ <- update(nftAnalysis)
      } yield ()
    }

    def onSuccessfulBuyFromMarket(nftId: String, price: MicroNumber, quantity: Int): Future[Unit] = {
      val nftAnalysis = Service.tryGet(nftId)
      val newBestOffer = masterSecondaryMarkets.Service.getBestOffer(nftId)
      for {
        nftAnalysis <- nftAnalysis
        newBestOffer <- newBestOffer
        _ <- Service.update(nftAnalysis.copy(totalListed = nftAnalysis.totalListed - quantity, bestOffer = newBestOffer, totalTraded = nftAnalysis.totalTraded + quantity, totalSold = nftAnalysis.totalSold + quantity, totalVolumeTraded = nftAnalysis.totalVolumeTraded + (price * quantity)))
      } yield ()
    }

    def onCancelSecondaryMarket(nftId: String, totalRemoved: Int): Future[Unit] = {
      val nftAnalysis = Service.tryGet(nftId)
      val newBestOffer = masterSecondaryMarkets.Service.getBestOffer(nftId)

      def update(nftAnalysis: NFTAnalysis, newBestOffer: MicroNumber) = {
        Service.update(nftAnalysis.copy(totalListed = nftAnalysis.totalListed - totalRemoved, bestOffer = newBestOffer))
      }

      for {
        nftAnalysis <- nftAnalysis
        newBestOffer <- newBestOffer
        _ <- update(nftAnalysis, newBestOffer)
      } yield ()
    }

    def onSuccessfulSellFromSale(nftId: String, quantity: Long): Future[Unit] = {
      val nftAnalysis = Service.tryGet(nftId)

      for {
        nftAnalysis <- nftAnalysis
        _ <- Service.update(nftAnalysis.copy(totalSold = nftAnalysis.totalSold + quantity))
      } yield ()
    }
  }
}