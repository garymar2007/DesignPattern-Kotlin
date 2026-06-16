package com.gary.designpattern.practices.behaviouralpatterns.observerlistener

import java.io.File

/**
 * Define a subscription mechanism to receive update messages.
 *
 * Notify multiple objects simultaneously.
 *
 * One to many relationship.
 */
interface EventListener {
    fun update(eventType: String?, file: File?)
}

class EventManager(vararg eventTypes: String) {
    var listeners = hashMapOf<String, ArrayList<EventListener>>()

    init {
        eventTypes.forEach {
            listeners[it] = arrayListOf()
        }
    }

    fun subscribe(eventType: String, listener: EventListener) {
        val userEvents: ArrayList<EventListener>? = listeners.get(eventType)
        userEvents?.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        val userEvents: ArrayList<EventListener>? = listeners.get(eventType)
        userEvents?.remove(listener)
    }

    fun notify(eventType: String?, file: File?) {
        val userEvents: ArrayList<EventListener>? = listeners.get(eventType)
        userEvents?.forEach {
            it.update(eventType, file)
        } ?: println("No listeners for $eventType")
    }
}

class Editor {
    var events: EventManager = EventManager("open", "save", "email", "sms", "whatsapp")

    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        events.notify("open", file)
    }

    fun saveFile() {
        file?.let {
            events.notify("save", file)
        }
    }

    fun sendEmail() {
        file?.let {
            events.notify("email", file)
        }
    }

    fun sendSms() {
        file?.let {
            events.notify("sms", file)
        }
    }

    fun sendWhatsApp() {
        file?.let {
            events.notify("whatsapp", file)
        }
    }
}

class EmailNotificationListener(private val email: String): EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Send email to $email: Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class SmsNotificationListener(private val sms: String): EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Send SMS to $sms: Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class WhatsAppNotificationListener(private val whatsApp: String): EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Send WhatsApp to $whatsApp: Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class LogOpenListener(val fileName: String): EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Save to log $fileName: Someone has performed $eventType operation with the file ${file?.name}")
    }
}
