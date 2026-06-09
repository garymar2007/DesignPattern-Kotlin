# Design Patterns In Kotlin

#### :warning: New article about testing: [Unit Testing with Mockito 2](https://github.com/dbacinski/Android-Testing-With-Kotlin/blob/master/docs/Unit-Testing-Mockito.md)

## Table of Contents

* [Behavioral Patterns](#behavioral)
  * [Observer / Listener](#observer--listener)
  * [Strategy](#strategy)
* [Creational Patterns] (#creational)



Behavioral
============

>In softwere engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these pattherns.  By doing so, these patterns increase flexibility in carrying out this communication.
>
>**Source:** [Wikipedia](https://en.wikipedia.org/wiki/Behavioral_pattern)

[Observer / Listener](/practice/behaviourpattern/observer-listener/Listener.kt)
---------
The observer pattern is used to allow an object to publish changes to its state.  Other objects subscribe to be immediately notified of any changes.

#### Example

```kotlin
interface TextChangedListener {

    fun onTextChanged(oldText: String, newText: String)
}

class PrintingTextChangedListener : TextChangedListener {
    
    private var text = ""
    
    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text is changed: $oldText -> $newText"
    }
}

class TextView {

    val listeners = mutableListOf<TextChangedListener>()

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach { it.onTextChanged(old, new) }
    }
}
```

[Strategy](/practice/behaviourpattern/strategy/Strategy.kt)
---------
The strategy pattern is used to create an interchangeable family of algorithms from which the required process is chosen at run-time.

#### Example
```kotlin
class Printer(private val stringFormatterStrategy: (String) -> String) {

    fun printString(string: String) {
        println(stringFormatterStrategy(string))
    }
}

val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }
val upperCaseFormatter = { it: String -> it.toUpperCase() }
```