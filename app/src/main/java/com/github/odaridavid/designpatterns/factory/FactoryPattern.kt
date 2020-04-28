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
package com.github.odaridavid.designpatterns.factory


open class Kitchen {
    fun setupEquipment() {
        println("Unpacking Equipment")
        println("Setting up...")
        Thread.sleep(2000)
        println("Equipment setup complete")
    }
}

class LShapedKitchen : Kitchen()

class PeninsulaKitchen : Kitchen()

class IslandKitchen : Kitchen()

enum class FloorPlan {
    SPACED, DETACHED, EXTENDING
}

object KitchenFloorFactory {
    inline fun <reified T> getFloorPlan(): FloorPlan {
        return when (T::class) {
            PeninsulaKitchen::class -> FloorPlan.DETACHED
            IslandKitchen::class -> FloorPlan.EXTENDING
            LShapedKitchen::class -> FloorPlan.SPACED
            else -> throw IllegalStateException("Unknown plan selected:No Available Kitchen")//or provide default
        }
    }
}

//Currency Example
sealed class Country

object Uganda : Country()
object Kenya : Country()
object Tanzania : Country()
object Rwanda : Country()

class Currency(val code: String)

object CurrencyFactory {
    fun getCurrency(country: Country): Currency {
        return when (country) {
            is Uganda -> Currency("UG")
            is Kenya -> Currency("KSH")
            is Tanzania -> Currency("TZ")
            is Rwanda -> Currency("RW")
        }
    }
}
