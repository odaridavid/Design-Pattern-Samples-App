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
package com.github.odaridavid.designpatterns.patterns.iterator

internal interface Iterator {
    val next: Car?
    fun hasNext(): Boolean
}

internal interface Container {
    fun createIterator(): Iterator
}

internal class Car(val name: String)

internal class CarIterator(private val cars: Array<Car>) : Iterator {

    var index: Int = 0

    override val next: Car?
        get() {
            val car = cars[index]
            index++
            return car
        }

    override fun hasNext(): Boolean = index < cars.size

}

internal class CarCollection : Container {

    override fun createIterator(): Iterator {
        val cars = arrayOf(Car("BMW"), Car("Tesla"), Car("Maserati"))
        return CarIterator(cars)
    }

}

internal class CarShowroom(private val carCollection: CarCollection = CarCollection()) {
    fun showcaseCars() {
        val iterator = carCollection.createIterator()
        while (iterator.hasNext()) {
            println("We have ${iterator.next?.name}")
        }
    }
}