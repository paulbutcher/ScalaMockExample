package com.example

import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory

class FunctionTest extends FunSuite with MockFactory {

  test("foldLeft") {
    val f = mockFunction[String, Int, String]
    
    inSequence {
      f expects ("initial", 0) returning "intermediate 1"
      f expects ("intermediate 1", 1) returning "intermediate 2"
      f expects ("intermediate 2", 2) returning "intermediate 3"
      f expects ("intermediate 3", 3) returning "final"
    }
    
    expectResult("final") { Seq(0, 1, 2, 3).foldLeft("initial")(f) }
  }
  
  test("where") {
    val f = mockFunction[Int, Int, String]
    
    f expects (where {_ < _}) returning "lower"
    f expects (where {_ > _}) returning "higher"
    
    expectResult("lower") { f(1, 2) }
    expectResult("higher") { f(2, 1) }
  }
  
  test("onCall") {
    val f = mockFunction[Int, Int, Int]
    
    f expects (*, *) onCall {_ + _}
    
    expectResult(5) { f(2, 3) }
  }
  
  test("complicated") {
    val f = mockFunction[Int, Int, Int]
    
    f expects (where {_ < _}) onCall {_ + _}
    f expects (where {_ > _}) onCall {_ - _}
    
    expectResult(3) { f(1, 2) }
    expectResult(5) { f(10, 5) }
  }
}