package com.gary.designpattern.practices.structuralpatterns.facade

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class FacadeTest : DescribeSpec({

    context("UserRepository") {
        it("should retrieve the saved user") {
            val userRepository = UserRepository()
            val user = User("garymar2007")

            userRepository.save(user)

            val retrievedUser = userRepository.findFirst()

            retrievedUser.login shouldBe user.login
        }
    }
})
