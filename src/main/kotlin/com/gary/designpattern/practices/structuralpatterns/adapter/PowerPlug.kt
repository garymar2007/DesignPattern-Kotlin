package com.gary.designpattern.practices.structuralpatterns.adapter

/**
 * 你的手机充电器忘在了办公室，在城市的另一头。你只有一款欧盟插头充电器和一根 USB 迷你
 * 线。但你的手机是 USB Type-C，因为你不得不升级。而且你人在纽约，所以所有的插座当然都是 US Type-A
 */
interface UsbTypeC

interface UsbMini

interface EUPlug

interface USPlug

fun powerOutlet(): USPlug {
    return object: USPlug {}
}

fun cellPhone(chargeCable: UsbTypeC) {

}

fun charger(plug: EUPlug) : UsbMini {
    return object: UsbMini {}
}

// In Kotlin, the extension functions are widely used as adapters
fun USPlug.toEUPlug(): EUPlug = object: EUPlug {}

fun UsbMini.toUsbTypeC(): UsbTypeC = object: UsbTypeC {}

fun main(args: Array<String>) {
    cellPhone(
        charger(powerOutlet().toEUPlug()).toUsbTypeC()
    )
}