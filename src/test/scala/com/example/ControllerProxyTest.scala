package com.example

import org.scalatest.FunSuite
import org.scalamock.ProxyMockFactory
import org.scalamock.scalatest.MockFactory
import scala.math.{Pi, sqrt}
 
class ControllerProxyTest extends FunSuite with MockFactory with ProxyMockFactory {
 
  test("draw line") {
    val mockTurtle = mock[Turtle]
    val controller = new Controller(mockTurtle)
 
    inSequence {
      inAnyOrder {
        mockTurtle expects 'penUp
        mockTurtle expects 'getPosition returning (0.0, 0.0)
        mockTurtle expects 'getAngle returning 0.0
      }
      mockTurtle expects 'turn withArgs(~(Pi / 4))
      mockTurtle expects 'forward withArgs(~sqrt(2.0))
      mockTurtle expects 'getAngle returning Pi / 4
      mockTurtle expects 'turn withArgs(~(-Pi / 4))
      mockTurtle expects 'penDown
      mockTurtle expects 'forward withArgs(1.0)
    }
 
    controller.drawLine((1.0, 1.0), (2.0, 1.0))
  }
}