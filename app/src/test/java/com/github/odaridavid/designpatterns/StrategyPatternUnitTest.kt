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
package com.github.odaridavid.designpatterns

import com.github.odaridavid.designpatterns.strategy.CashOnDelivery
import com.github.odaridavid.designpatterns.strategy.MarkdownFormatter
import com.github.odaridavid.designpatterns.strategy.Mpesa
import com.github.odaridavid.designpatterns.strategy.Order
import org.junit.Test


class StrategyPatternUnitTest {

    @Test
    fun strategyPattern() {
        val order = Order()
        assert(order.submitOrder() == "No Payment Option Selected")

        order.setStrategy(Mpesa())
        assert(order.submitOrder() == "Pay by M-pesa")

        order.setStrategy(CashOnDelivery())
        assert(order.submitOrder() == "Pay on Delivery")
    }

    @Test
    fun strategyPattern_functional() {
        val boldFormatter = { text: String -> "*$text*" }
        val strikeThroughFormatter = {text:String->"~$text~"}
        val markdownFormatter = MarkdownFormatter(boldFormatter)
        markdownFormatter.format("Random text")
        markdownFormatter.formatterStrategy = strikeThroughFormatter
        markdownFormatter.format("Random text")

    }
}
