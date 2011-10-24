package com.example
 
import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.generated.GeneratedMockFactory
 
class ColouredTurtleTest extends FunSuite with MockFactory with GeneratedMockFactory {
 
  test("coloured turtles") {
    val m1 = mock[ColouredTurtle]
    val m2 = mock[ColouredTurtle]
 
    m1.expects.newInstance(1.0, 0.0, 0.0)
    m2.expects.newInstance(0.0, 1.0, 0.0)
    m2.expects.forward(3.0)
 
    val t1 = ColouredTurtle('red)
    val t2 = ColouredTurtle('green)
    t2.forward(3.0)
  }
  
  test("ink reservoir") {
    val m = mockObject(InkReservoir)

    m.expects.use(0.0, 3.0, 0.0)

    val t = ColouredTurtle('green)
    t.penDown
    t.forward(3.0)
  }
}