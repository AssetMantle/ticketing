package actors

import actors.Message.PushNotification
import akka.actor.{Actor, ActorLogging}
import play.api.Logger

import javax.inject.Singleton
import scala.concurrent.ExecutionContext

@Singleton
class PushNotificationActor() extends Actor with ActorLogging {

  private implicit val executionContext: ExecutionContext = context.dispatcher

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Actor.ACTOR_PUSH_NOTIFICATION

  def receive: PartialFunction[Any, Unit] = {
    case pushNotification: PushNotification => logger.info(pushNotification.token)
  }

}