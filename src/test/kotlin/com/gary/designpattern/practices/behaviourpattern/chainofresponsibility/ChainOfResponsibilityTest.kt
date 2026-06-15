package com.gary.designpattern.practices.behaviourpattern.chainofresponsibility

import com.gary.designpattern.practices.behaviouralpatterns.chainofresponsibility.AuthenticationHeader
import com.gary.designpattern.practices.behaviouralpatterns.chainofresponsibility.BodyPayloadHeader
import com.gary.designpattern.practices.behaviouralpatterns.chainofresponsibility.ContentTypeHeader
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ChainOfResponsibilityTest: DescribeSpec({

    context("ChainOfResponsibility") {
        it("should retrieve the saved user") {
            val bodyPayloadHeader = BodyPayloadHeader("Body: {\"username\" = \"John\"}")
            val contentTypeHeader = ContentTypeHeader("application/json", bodyPayloadHeader)
            val authenticationHeader = AuthenticationHeader("Bearer 1234567890", contentTypeHeader)

            val messageWithAuthentication = authenticationHeader.addHeader("Headers with authentication")
            messageWithAuthentication shouldBe "Headers with authentication\nAuthentication: Bearer 1234567890\nContentType: application/json\nBody: {\"username\" = \"John\"}"

            val messageWithoutAuthentication = contentTypeHeader.addHeader("Headers without authentication")
            messageWithoutAuthentication shouldBe "Headers without authentication\nContentType: application/json\nBody: {\"username\" = \"John\"}"

            val messageWithBody = bodyPayloadHeader.addHeader("Headers with body")
            messageWithBody shouldBe "Headers with body\nBody: {\"username\" = \"John\"}"
        }
    }
})