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
package com.github.odaridavid.designpatterns.strategy


interface BillingStrategy {
    fun pay(): String
}

class Mpesa : BillingStrategy {
    override fun pay(): String = "Pay by M-pesa"
}

class CashOnDelivery : BillingStrategy {
    override fun pay(): String = "Pay on Delivery"
}

class Order {
    private var billingStrategy: BillingStrategy? = null

    fun setStrategy(billingStrategy: BillingStrategy) {
        this.billingStrategy = billingStrategy
    }

    fun submitOrder(): String {
        return billingStrategy?.pay() ?: "No Payment Option Selected"
    }
}

//functional

class MarkdownFormatter(var formatterStrategy: (String) -> String) {
    fun format(string: String) {
        println(formatterStrategy(string))
    }
}