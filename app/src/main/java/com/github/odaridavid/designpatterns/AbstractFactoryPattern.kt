package com.github.odaridavid.designpatterns

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
interface Saloon {
    val color: String
    fun isAutomatic(): Boolean
}

interface Truck {
    val color: String
    fun noOfWheels(): Int
}

interface SUV {
    val color: String
    fun isFourWheelDrive(): Boolean
}

class Nissan(override val color: String) : Saloon {
    override fun isAutomatic(): Boolean = true
}

class Bently(override val color: String) : Saloon {
    override fun isAutomatic(): Boolean = false
}

class Isuzu(override val color: String) : Truck {
    override fun noOfWheels(): Int = 18
}

class Benz(override val color: String) : Truck {
    override fun noOfWheels(): Int = 22
}

class Harrier(override val color: String) : SUV {
    override fun isFourWheelDrive(): Boolean {
        return false
    }
}

class Hummer(override val color: String) : SUV {
    override fun isFourWheelDrive(): Boolean = true
}

abstract class CarTypeAbstractFactory {
    abstract fun getTruck(): Truck
    abstract fun getSaloon(): Saloon
    abstract fun getSUV(): SUV
    fun pumpFuel() {
        println("Fuel in all cars good to go")
    }
}

class SimpleCarFactory : CarTypeAbstractFactory() {
    override fun getTruck(): Truck {
        return Isuzu("White")
    }

    override fun getSaloon(): Saloon {
        return Nissan("Grey")
    }

    override fun getSUV(): SUV {
        return Harrier("Red")
    }
}

class SophisticatedCarFactory : CarTypeAbstractFactory() {
    override fun getTruck(): Truck {
        return Benz("Black")
    }

    override fun getSaloon(): Saloon {
        return Bently("Chrome-Silver")
    }

    override fun getSUV(): SUV {
        return Hummer("Yellow")
    }
}

