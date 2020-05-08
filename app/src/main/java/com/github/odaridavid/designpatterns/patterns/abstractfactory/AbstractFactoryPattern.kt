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
package com.github.odaridavid.designpatterns.patterns.abstractfactory

internal interface Truck {
    val color: String
    fun noOfWheels(): Int
}

internal class Isuzu(override val color: String) :
    Truck {
    override fun noOfWheels(): Int = 18
}

internal class Benz(override val color: String) :
    Truck {
    override fun noOfWheels(): Int = 22
}


internal abstract class CarFactory {
    abstract fun getTruck(): Truck

    companion object {
        @JvmStatic
        inline fun <reified T> createTruckFactory(): CarFactory {
            return when (T::class) {
                JapanTruckFactory::class -> JapanTruckFactory()
                GermanTruckFactory::class -> GermanTruckFactory()
                else -> throw IllegalStateException("Unidentified truck factory")
            }
        }
    }
}

internal class JapanTruckFactory : CarFactory() {
    override fun getTruck(): Truck = Isuzu(color = "White")
}

internal class GermanTruckFactory : CarFactory() {
    override fun getTruck(): Truck = Benz(color = "Black")
}

