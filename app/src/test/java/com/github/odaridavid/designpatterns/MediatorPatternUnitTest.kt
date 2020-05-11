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

import com.github.odaridavid.designpatterns.patterns.mediator.Parcel
import com.github.odaridavid.designpatterns.patterns.mediator.ParcelMediator
import com.github.odaridavid.designpatterns.patterns.mediator.User
import org.junit.Test


internal class MediatorPatternUnitTest {

    @Test
    fun parcel_mediatorPattern() {
        val john = User(
            name = "John",
            parcelId = 1
        )
        val mary = User(
            name = "Mary",
            parcelId = 1
        )
        val don = User(
            name = "Don",
            parcelId = 2
        )

        val parcelMediator = ParcelMediator()
        val parcel = Parcel(
            id = 1,
            status = "En-Route",
            mediator = parcelMediator
        )

        parcelMediator.receivers(john)
        parcelMediator.receivers(mary)
        //Won't Receive
        parcelMediator.receivers(don)

        parcel.sendParcel()
    }
}
