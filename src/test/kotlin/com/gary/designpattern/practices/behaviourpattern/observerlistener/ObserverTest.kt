package com.gary.designpattern.practices.behaviourpattern.observerlistener

import com.gary.designpattern.practices.behaviouralpatterns.observerlistener.Editor
import com.gary.designpattern.practices.behaviouralpatterns.observerlistener.EmailNotificationListener
import com.gary.designpattern.practices.behaviouralpatterns.observerlistener.LogOpenListener
import com.gary.designpattern.practices.behaviouralpatterns.observerlistener.SmsNotificationListener
import com.gary.designpattern.practices.behaviouralpatterns.observerlistener.WhatsAppNotificationListener
import io.kotest.core.spec.style.DescribeSpec

class ObserverTest : DescribeSpec({

    context("Observer") {
        it("test the event listeners") {
            val editor = Editor()
            editor.events.subscribe("open", LogOpenListener("~/garymar2007/DesignPattern-Kotlin/logs/eventLog.log"))
            editor.events.subscribe("email", EmailNotificationListener("test@test.com"))
            editor.events.subscribe("sms", SmsNotificationListener("+27721234567"))
            editor.events.subscribe("whatsapp", WhatsAppNotificationListener("+27721234567"))

            editor.openFile("~/garymar2007/DesignPattern-Kotlin/README.md")
            editor.saveFile()
            editor.sendEmail()
            editor.sendSms()
            editor.sendWhatsApp()
        }
    }

})