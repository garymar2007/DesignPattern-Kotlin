package com.gary.designpattern.practices.behaviourpattern.observerlistener

import kotlin.properties.Delegates

/**
 * 观察者模式Observer
 *
 * 功能:文本框内容变化时通知其他监听器发生变化
 *
 */
class Listener {

    interface TextChangedListener {
        fun onTextChanged(oldText: String, newText: String)
    }

    class PrintingTextChangeListener : TextChangedListener {
        val printedText = mutableListOf<String>()

        override fun onTextChanged(oldText: String, newText: String) {
            println("Text is changed: $oldText -> $newText")
            printedText.add("Text is changed: $oldText -> $newText")
        }
    }

    class TextView {
        val listeners = mutableListOf<TextChangedListener>()

        var text: String by Delegates.observable("<empty>") { _, old, newValue ->
            listeners.forEach { it.onTextChanged(old, newValue) }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val textView = TextView().apply {
                listeners.add(PrintingTextChangeListener())
            }

            with(textView) {
                text = "Hello"
                text = "World"
            }
        }
    }

}
