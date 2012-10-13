package com.example
 
import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import scala.math.{Pi, sqrt}
 
class ControllerTest extends FunSuite with MockFactory {
 
  test("draw line") {
    val mockTurtle = mock[Turtle]
    val controller = new Controller(mockTurtle)
 
    inSequence {
      inAnyOrder {
        (mockTurtle.penUp _).expects()
        (mockTurtle.getPosition _).expects().returning(0.0, 0.0)
        (mockTurtle.getAngle _).expects().returning(0.0)
      }
      (mockTurtle.turn _).expects(~(Pi / 4))
      (mockTurtle.forward _).expects(~sqrt(2.0))
      (mockTurtle.getAngle _).expects().returning(Pi / 4)
      (mockTurtle.turn _).expects(~(-Pi / 4))
      (mockTurtle.penDown _).expects()
      (mockTurtle.forward _).expects(1.0)
    }
 
    controller.drawLine((1.0, 1.0), (2.0, 1.0))
  }
}