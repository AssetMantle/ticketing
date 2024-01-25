package constants

import org.bitcoinj.crypto.ChildNumber
import utilities.Wallet

object Secret {

  private var memoSignerMnemonics: Seq[String] = Seq()

  private var mantlePlaceMnemonics: Seq[String] = Seq()

  private var mintNFTCampaignMnemonics: Seq[String] = Seq()

  private var Sealed: Boolean = false

  private val IssueIdentityHDPath: Seq[ChildNumber] = Seq(
    new ChildNumber(44, true),
    new ChildNumber(constants.Blockchain.CoinType, true),
    new ChildNumber(0, true),
    new ChildNumber(0, false),
    new ChildNumber(1, false)
  )

  private val DefineAccountHDPath: Seq[ChildNumber] = Seq(
    new ChildNumber(44, true),
    new ChildNumber(constants.Blockchain.CoinType, true),
    new ChildNumber(0, true),
    new ChildNumber(0, false),
    new ChildNumber(2, false)
  )

  private val MintAssetHDPath: Seq[ChildNumber] = Seq(
    new ChildNumber(44, true),
    new ChildNumber(constants.Blockchain.CoinType, true),
    new ChildNumber(0, true),
    new ChildNumber(0, false),
    new ChildNumber(3, false)
  )

  def memoSignerWallet: Wallet = if (memoSignerMnemonics.nonEmpty) utilities.Wallet.getWallet(memoSignerMnemonics)
  else throw new IllegalArgumentException("MEMO_SIGNER_MNEMONICS_EMPTY")

  def issueIdentityWallet: Wallet = if (mantlePlaceMnemonics.nonEmpty) utilities.Wallet.getWallet(mantlePlaceMnemonics, hdPath = IssueIdentityHDPath)
  else throw new IllegalArgumentException("MANTLE_PLACE_MNEMONICS_EMPTY")

  def defineAssetWallet: Wallet = if (mantlePlaceMnemonics.nonEmpty) utilities.Wallet.getWallet(mantlePlaceMnemonics, hdPath = DefineAccountHDPath)
  else throw new IllegalArgumentException("MANTLE_PLACE_MNEMONICS_EMPTY")

  def mintAssetWallet: Wallet = if (mantlePlaceMnemonics.nonEmpty) utilities.Wallet.getWallet(mantlePlaceMnemonics, hdPath = MintAssetHDPath)
  else throw new IllegalArgumentException("MANTLE_PLACE_MNEMONICS_EMPTY")

  def nftAirDropWallet: Wallet = if (mintNFTCampaignMnemonics.nonEmpty) utilities.Wallet.getWallet(mintNFTCampaignMnemonics)
  else throw new IllegalArgumentException("MINT_NFT_CAMPAIGN_MNEMONICS_EMPTY")

  def setSecrets(memoSignerSeeds: Seq[String], mantlePlaceSeeds: Seq[String], mintNFTCampaignSeeds: Seq[String]): Unit = if (!Sealed) {
    memoSignerMnemonics = memoSignerSeeds
    mantlePlaceMnemonics = mantlePlaceSeeds
    mintNFTCampaignMnemonics = mintNFTCampaignSeeds
    Sealed = true
  }

}
