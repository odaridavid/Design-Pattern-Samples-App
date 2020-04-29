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
package com.github.odaridavid.designpatterns.bridge

interface IFurniture {
    fun getMaterial(): String
    fun matchWithAmbience(effects: String): String
    fun getAmbience(): String
}

class Chair : IFurniture {

    private var ambience: String = ""

    override fun getMaterial(): String {
        return "Chair Material"
    }

    override fun matchWithAmbience(effects: String): String {
        ambience = "$effects Chair"
        return ambience
    }

    override fun getAmbience(): String {
        return ambience.replace("Chair", "", true).trim()
    }
}

abstract class FurnitureShop(private val furniture: IFurniture) {

    fun setDisplay() {
        println("${furniture.getMaterial()} On Display ")
    }

    abstract fun setAmbience()
}

class VintageFurnitureShop(openingHours: String, private val furniture: IFurniture) :
    FurnitureShop(furniture) {

    init {
        setDisplay()
        println("Open from $openingHours")
    }

    override fun setAmbience() {
        furniture.matchWithAmbience("Vintage")
    }
}

//TODO Revisit Bridge pattern
