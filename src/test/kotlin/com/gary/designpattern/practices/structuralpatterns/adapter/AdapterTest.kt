package com.gary.designpattern.practices.structuralpatterns.adapter

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class AdapterTest : DescribeSpec({

    context("Adapter Test") {
        it("test adapter conversion") {
            val generator = DatabaseDataGenerator()
            val generatedData = generator.generateData()
            val adapter = DataDisplayAdapter(DataDisplay())
            val convertedData = adapter.convert(generatedData)

            convertedData.size.shouldBe(4)
            convertedData[1].index.shouldBe(2)
            convertedData[1].data.shouldBe("200")
        }
    }
})