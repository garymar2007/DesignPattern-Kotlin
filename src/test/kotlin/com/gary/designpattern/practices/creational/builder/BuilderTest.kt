package com.gary.designpattern.practices.creational.builder

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class BuilderTest : DescribeSpec({

    context("Builder Test") {
        it("test building a component") {

            val component = Component.Builder().setParam1("some value").setParam3(true).builder()

            component.should {
                it.param1.shouldBe("some value")
                it.param2.shouldBe(null)
                it.param3.shouldBe(true)
            }
        }
    }

})