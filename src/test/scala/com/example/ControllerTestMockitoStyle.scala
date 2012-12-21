package com.example
 
import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import scala.math.{Pi, sqrt}
import scala.language.postfixOps
 
class ControllerTestMockitoStyle extends FunSuite with MockFactory {
 
  test("draw line") {
    val mockTurtle = stub[Turtle]
    val controller = new Controller(mockTurtle)
 
    inSequence {
      inAnyOrder {
        (mockTurtle.getPosition _) when () returns (0.0, 0.0)
        (mockTurtle.getAngle _) when () returns 0.0 once
      }
      (mockTurtle.getAngle _) when () returns Pi / 4
    }
 
    controller.drawLine((1.0, 1.0), (2.0, 1.0))
    
    inSequence {
      (mockTurtle.turn _) verify ~(Pi / 4)
      (mockTurtle.forward _) verify ~sqrt(2.0)
      (mockTurtle.turn _) verify ~(-Pi / 4)
      (mockTurtle.penDown _) verify ()
      (mockTurtle.forward _) verify 1.0
    }
  }
}