package com.gary.designpattern.practices.creational.builder

/**
 * Used when we have multiple parameters to initialize.
 *
 *
 */
class Component private constructor(builder: Builder) {
    var param1: String? = null
    var param2: Int? = null
    var param3: Boolean? = null

    class Builder {
        private var param1: String? = null
        private var param2: Int? = null
        private var param3: Boolean? = null

        fun setParam1(param1: String?): Builder = apply {
            this.param1 = param1
        }

        fun setParam2(param2: Int?): Builder = apply {
            this.param2 = param2
        }

        fun setParam3(param3: Boolean?): Builder = apply {
            this.param3 = param3
        }

        fun builder() = Component(this)

        fun getParam1() = param1
        fun getParam2() = param2
        fun getParam3() = param3
    }

    init {
        param1 = builder.getParam1()
        param2 = builder.getParam2()
        param3 = builder.getParam3()
    }
}