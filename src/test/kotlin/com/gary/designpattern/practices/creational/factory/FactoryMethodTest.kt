package com.gary.designpattern.practices.creational.factory

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class FactoryMethodTest : DescribeSpec({

    context("Factory Method") {
        it("test Currency as per country") {
            val chineseCurrency = CurrencyFactory.currencyForCountry(China("")).code
            chineseCurrency.shouldBe("CNY")

            val usaCurrency = CurrencyFactory.currencyForCountry(USA("")).code
            usaCurrency.shouldBe("USD")

            val spainCurrency = CurrencyFactory.currencyForCountry(Spain).code
            spainCurrency.shouldBe("EUR")
        }
    }

})