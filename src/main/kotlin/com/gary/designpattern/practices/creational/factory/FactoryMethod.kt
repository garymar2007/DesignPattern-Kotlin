package com.gary.designpattern.practices.creational.factory

/**
 * Provides a way to access functionality without caring about implementation.
 *
 * Separation of concerns.
 *
 * Allows for testability.
 */
sealed class Country {
    object Canada: Country()
}

object Spain: Country()
class Greece(val someProperty: String): Country()

data class USA(val someProperty: String): Country()

data class China(val someProperty: String): Country()

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        // exhaustive when
        when(country) {
            is Country.Canada -> Currency("CAD")
            is Spain -> Currency("EUR")
            is Greece -> Currency("EUR")
            is USA -> Currency("USD")
            is China -> Currency("CNY")
        }
}