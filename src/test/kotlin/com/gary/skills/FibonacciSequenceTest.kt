package com.gary.skills

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlin.test.assertEquals

class FibonacciSequenceTest : DescribeSpec({

    describe("fibonacciSequence") {
     it("test first 20 fibonacciSequence") {
      val fibs = fibonacciSequence().take(20).toList()

      assertEquals(listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181), fibs)
     }
    }
})
