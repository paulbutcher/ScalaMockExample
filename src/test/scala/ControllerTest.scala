package com.example
 
import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.generated.GeneratedMockFactory
import scala.math.{Pi, sqrt}
 
class ControllerTest extends FunSuite with MockFactory with GeneratedMockFactory {
 
  test("draw line") {
    val mockTurtle = mock[Turtle]
    val controller = new Controller(mockTurtle)
 
    inSequence {
      inAnyOrder {
        mockTurtle.expects.penUp
        mockTurtle.expects.getPosition returning (0.0, 0.0)
        mockTurtle.expects.getAngle returning 0.0
      }
      mockTurtle.expects.turn(~(Pi / 4))
      mockTurtle.expects.forward(~sqrt(2.0))
      mockTurtle.expects.getAngle returning Pi / 4
      mockTurtle.expects.turn(~(-Pi / 4))
      mockTurtle.expects.penDown
      mockTurtle.expects.forward(1.0)
    }
 
    controller.drawLine((1.0, 1.0), (2.0, 1.0))
  }
}