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
package com.github.odaridavid.designpatterns.patterns.factory


sealed class Chair(val capacity: Int)

class Sofa(capacity: Int) : Chair(capacity)

class ParkBench(capacity: Int) : Chair(capacity)

object ChairFactory {
    @JvmStatic
    inline fun <reified T> getChair(): Chair {
        return when (T::class) {
            Sofa::class -> Sofa(5)
            ParkBench::class -> ParkBench(3)
            else -> throw IllegalArgumentException("Unknown type of chair")
        }
    }
}

