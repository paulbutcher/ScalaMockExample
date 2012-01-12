package com.example

import scala.math.{cos, sin}
 
class ColouredTurtle(r: Double, g: Double, b: Double) extends Turtle {
  def penDown() { penIsDown = true }
  def penUp() { penIsDown = false }
  def turn(angle: Double) { theta += angle}
  def getPosition: (Double, Double) = (x, y)
  def getAngle: Double = theta
  def forward(d: Double) { 
    x += sin(theta) * d
    y += cos(theta) * d
    if (penIsDown)
      InkReservoir.use(r * d, g * d, b * d)
  }
 
  private var penIsDown = false
  private var x = 0.0
  private var y = 0.0
  private var theta = 0.0
}
 
object ColouredTurtle {
 
  def apply(colour: Symbol) = {
    val (r, g, b) = colourMap(colour)
    new ColouredTurtle(r, g, b)
  }
 
  private val colourMap = Map(
    'red -> (1.0, 0.0, 0.0), 
    'green -> (0.0, 1.0, 0.0), 
    'blue -> (0.0, 0.0, 1.0))
}