package com.diatom.island

import com.diatom.island.population.TParetoFrontier

import scala.concurrent.duration.Duration

/**
  * An evolutionary process with a set of actors that all act upon one set of solutions.
  */
trait TEvolutionaryProcess[Solution] {
  /**
    * Run this island, until the specified termination criteria is met. This call will block
    * until the termination criteria is completed.
    *
    * @return this
    */
  def run(terminationCriteria: TTerminationCriteria): TEvolutionaryProcess[Solution]

  //TODO add a runAsync(), will be required for a controller

  /**
    * @return the current pareto frontier of solutions on this island?
    */
  def currentParetoFrontier(): TParetoFrontier[Solution]
}

/**
  * Tells you how long to run an island for.
  */
trait TTerminationCriteria {
  /**
    * Stop after the specified duration has elapsed.
    */
  def time: Duration
}

case class TerminationCriteria(time: Duration) extends TTerminationCriteria