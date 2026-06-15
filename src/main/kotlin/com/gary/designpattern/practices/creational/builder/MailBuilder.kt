package com.gary.designpattern.practices.creational.builder

import java.io.File

data class Mail(private val to: String,
                private var title: String = "",
                private var message: String = "",
                private var cc: List<String> = listOf(),
                private var bcc: List<String> = listOf(),
                private var attachments: List<File> = listOf()
) {
    fun message(message: String): Mail {
        this.message = message
        return this
    }
    fun title(title: String): Mail {
        this.title = title
        return this
    }

    fun cc(cc: List<String>): Mail {
        this.cc = cc
        return this
    }

    fun bcc(bcc: List<String>): Mail {
        this.bcc = bcc
        return this
    }

    fun attachments(attachments: List<File>): Mail {
        this.attachments = attachments
        return this
    }
}

class MailBuilder(
    to: String,
) {
    private var mail: Mail = Mail(to)

    fun title(title: String): MailBuilder {
        mail = mail.title(title)
        return this
    }

    fun message(message: String): MailBuilder {
        mail = mail.message(message)
        return this
    }

    fun attachments(listOfFiles: List<File>): MailBuilder {
        mail = mail.attachments(listOfFiles)
        return this
    }
}

fun main(args: Array<String>) {
    val email = MailBuilder("email@com.co.za").title("test").message("This is a test")
}