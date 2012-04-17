package com.example
 
import scala.math.{atan2, sqrt}
 
class Controller(turtle: Turtle) {
 
  def drawLine(start: (Double, Double), end: (Double, Double)) {
    moveTo(start)
 
    val initialAngle = turtle.getAngle
    val deltaPos = delta(start, end)
 
    turtle.turn(angle(deltaPos) - initialAngle)
    turtle.penDown
    turtle.forward(distance(deltaPos))
  }
 
  def delta(pos1: (Double, Double), pos2: (Double, Double)) = 
    (pos2._1 - pos1._1, pos2._2 - pos1._2)
 
  def distance(delta: (Double, Double)) = 
    sqrt(delta._1 * delta._1 + delta._2 * delta._2)
 
  def angle(delta: (Double, Double)) = 
    atan2(delta._2, delta._1)
 
  def moveTo(pos: (Double, Double)) {
    val initialPos = turtle.getPosition
    val initialAngle = turtle.getAngle
 
    val deltaPos = delta(initialPos, pos)
 
    turtle.penUp
    turtle.turn(angle(deltaPos) - initialAngle)
    turtle.forward(distance(deltaPos))
  }
}