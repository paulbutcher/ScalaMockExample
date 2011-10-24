package com.example
 
trait Turtle {
  def penDown()
  def penUp()
  def forward(distance: Double)
  def turn(angle: Double)
  def getPosition: (Double, Double)
  def getAngle: Double
}