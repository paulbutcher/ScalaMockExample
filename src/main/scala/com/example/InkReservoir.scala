package com.example
 
object InkReservoir {
 
  def use(r: Double, g: Double, b: Double) {
    red -= r
    green -= g
    blue -= b
  }
 
  private var red = 10.0
  private var green = 10.0
  private var blue = 10.0
}