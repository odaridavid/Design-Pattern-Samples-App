/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns.patterns.chainofresponsibility

internal interface OrderHandler {
    val nextHandler: OrderHandler?
    fun handleRequest(order: Order)
}

internal interface Order {
    val items: Map<String, Int>
}

internal class IceCreamOrder(override val items: Map<String, Int>) : Order

internal class IceCreamVendor(override val nextHandler: OrderHandler?) : OrderHandler {
    override fun handleRequest(order: Order) {
        val orderSize = order.items.values.sum()
        if (orderSize > 5) {
            println("Vendor: I'll have to get some")
            nextHandler?.handleRequest(order) ?: println("This is the end buddy")
        } else {
            println("OrderTransaction of ${order.items.keys} coming right up")
        }
    }
}

internal class IceCreamRetailer(override val nextHandler: OrderHandler?) : OrderHandler {
    override fun handleRequest(order: Order) {
        val orderSize = order.items.values.sum()
        if (orderSize > 10) {
            println("Retailer: Hmm guess I'll have to order more too")
            nextHandler?.handleRequest(order) ?: println("This is the end buddy")
        } else {
            println("OrderTransaction of ${order.items.keys} enroute to vendor")
        }
    }
}

internal class IceCreamFactory(override val nextHandler: OrderHandler?) : OrderHandler {
    override fun handleRequest(order: Order) {
        val orderSize = order.items.values.sum()
        if (orderSize > 100) {
            nextHandler?.handleRequest(order) ?: println("This is the end buddy")
        } else {
            println("Factory: OrderTransaction of ${order.items.keys} coming enroute to retailer")
        }
    }
}

