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
package com.github.odaridavid.designpatterns.visitor


interface Visitor {
    fun visit(hotel: Hotel)
    fun visit(lodging: Lodging)
    fun visit(airBnb: AirBnb)
}

interface Accomodation {
    val rating: Int
    fun accept(visitor: Visitor)
}

class AccomodationVisitor : Visitor {

    override fun visit(hotel: Hotel) {
        println("Hotel rating on visit ${hotel.rating}")
    }

    override fun visit(lodging: Lodging) {
        println("Lodging rating on visit ${lodging.rating}")
    }

    override fun visit(airBnb: AirBnb) {
        println("Airbnb rating on visit ${airBnb.rating}")
    }

}

class Hotel(override val rating: Int) : Accomodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Lodging(override val rating: Int) : Accomodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class AirBnb(override val rating: Int) : Accomodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}