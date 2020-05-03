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
package com.github.odaridavid.designpatterns.adapter

class Water(val source: String)

interface WaterProvider {
    fun pumpWater(source: String): Water
}

open class OldWaterPump : WaterProvider {
    override fun pumpWater(source: String): Water {
        return Water(source)
    }
}

class WaterFilter {
    fun filterWater(source: String): Water {
        return Water("Filtered $source Water")
    }
}

class WaterFilterAdapter(private val waterFilter: WaterFilter) : OldWaterPump() {

    override fun pumpWater(source: String): Water {
        return waterFilter.filterWater(source)
    }
}