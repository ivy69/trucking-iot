package com.orendainx.trucking.simulator.transmitters

import akka.actor.{ActorLogging, ActorRef, Props}
import com.orendainx.trucking.simulator.transmitters.DataTransmitter.Transmit

/**
  * @author Edgar Orendain <edgar@orendainx.com>
  */
object ActorTransmitter {

  def props(outActr: ActorRef) = Props(new ActorTransmitter(outActr))
}

class ActorTransmitter(outActr: ActorRef) extends DataTransmitter with ActorLogging {

  def receive = {
    case Transmit(data) => outActr ! data
  }
}
