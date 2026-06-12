package com.gary.designpattern.practices.behaviourpattern.observerlistener

import com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.observerlistener.Listener
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class ListenerTest : DescribeSpec({

    context("Listener") {
        it("test view should be changed from old string to new string") {
            val listener = Listener.PrintingTextChangeListener()

            val textView = Listener.TextView().apply {
                listeners.add(listener)
            }

            with(textView) {
                text = "Hello"
                text shouldBe "Hello"
                text = "World"
                text shouldBe "World"
            }

            listener.printedText.should {
                it.size shouldBe 2
                it.first().shouldBe("Text is changed: <empty> -> Hello")
                it.last().shouldBe("Text is changed: Hello -> World")
            }
        }
    }

})
