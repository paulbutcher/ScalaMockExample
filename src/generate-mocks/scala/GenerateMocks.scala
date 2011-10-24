package com.example
 
import org.scalamock.annotation.{mock, mockObject}
 
@mock[Turtle]
@mock[ColouredTurtle]
@mockObject(InkReservoir)
class Dummy