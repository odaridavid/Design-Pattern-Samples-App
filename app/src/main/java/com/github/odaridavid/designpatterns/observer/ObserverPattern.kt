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
package com.github.odaridavid.designpatterns.observer


interface OrderObserver {
    fun onReceived()
}

class OrderRepository {

    private val observers = ArrayList<OrderObserver>()

    fun subscribe(orderObserver: OrderObserver) {
        observers.add(orderObserver)
    }

    fun unsubscribe(orderObserver: OrderObserver) {
        observers.remove(orderObserver)
    }

    fun notifyObservers() {
        for (observer in observers) {
            observer.onReceived()
        }
    }
}

class Customer : OrderObserver {
    override fun onReceived() {
        println("Customer Received Order")
    }

}

class Store : OrderObserver {
    override fun onReceived() {
        println("Order Delivered Successfully")
    }

}