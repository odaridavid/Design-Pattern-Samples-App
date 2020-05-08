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

import com.github.odaridavid.designpatterns.patterns.strategy.CashOnDelivery
import com.github.odaridavid.designpatterns.patterns.strategy.Mpesa
import com.github.odaridavid.designpatterns.patterns.strategy.OrderTransaction
import org.junit.Test


class StrategyPatternUnitTest {

    @Test
    fun billing_strategyPattern() {
        val order = OrderTransaction { billingStrategy -> billingStrategy.pay() }
        assert(order.finalizeTransaction().contains("No Billing Method Selected"))

        order.billingStrategy = Mpesa()
        assert(order.finalizeTransaction().contains("Pay through M-pesa"))

        order.billingStrategy = CashOnDelivery()
        assert(order.finalizeTransaction().contains("Pay cash on delivery"))
    }

}
