package com.gary.designpattern.practices.structuralpatterns.adapter

/**
 * Convert the interface of a class into another interface clients expect.
 *
 * Convert data from one format to another.
 *
 */

// the 3rd party library - cannot be modified
data class DisplayDataType(val index: Float, val data: String)

class DataDisplay {
    fun displayData(data: DisplayDataType) {
        println("Displaying data: ${data.index} - ${data.data}")
    }
}

// Local code
data class DatabaseData(val position: Int, val amount: Int)

class DatabaseDataGenerator {
    fun generateData(): List<DatabaseData> {
        val list = arrayListOf<DatabaseData>()
        list.add(DatabaseData(1, 150))
        list.add(DatabaseData(2, 200))
        list.add(DatabaseData(3, 250))
        list.add(DatabaseData(4, 300))

        return list
    }
}

// Adapter class
interface DatabaseDataConverter {
    fun convert(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(val display: DataDisplay): DatabaseDataConverter {
    override fun convert(data: List<DatabaseData>): List<DisplayDataType> {
        return data.map { DisplayDataType(it.position.toFloat(), it.amount.toString()) }.apply {
            this.forEach { display.displayData(it) }
        }
    }
}

