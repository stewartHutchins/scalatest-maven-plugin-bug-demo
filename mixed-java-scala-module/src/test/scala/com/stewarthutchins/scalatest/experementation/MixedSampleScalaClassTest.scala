package com.stewarthutchins.scalatest.experementation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MixedSampleScalaClassTest extends AnyFlatSpec with Matchers {

  "When I check the toString, it" should "correct" in {
    val mySampleClass = new MixedSampleScalaClass
    val toString: String = mySampleClass.toString()

    toString should include("MixedSampleScalaClass")
  }

}
