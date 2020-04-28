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
package com.github.odaridavid.designpatterns.builder

import androidx.annotation.FloatRange

//With constructor
class PizzaBuilder(
    private var type: PizzaType = PizzaType.BEEF,
    private var size: PizzaSize = PizzaSize.SMALL,
    private var extraCheese: Boolean = false
) {
    fun build(): Pizza {
        return Pizza(type, size, extraCheese)
    }
}

data class Pizza(val pizzaType: PizzaType, val pizzaSize: PizzaSize, val extraCheese: Boolean)

enum class PizzaSize {
    SMALL, MEDIUM, LARGE
}

enum class PizzaType {
    CHICAGO_STYLE, VEGETABLE, BEEF
}

object GameEnvironmentBuilder {

    private var quality = RenderQuality.MEDIUM
    private var frequency = 0.0f
    private var timeOfDay = TimeOfDay.MORNING
    private var scene = Scene.BARRACKS

    fun setRenderQuality(quality: RenderQuality): GameEnvironmentBuilder {
        this.quality = quality
        return this
    }

    fun setRocksFrequency(
        @FloatRange(from = 0.0, to = 1.0) frequency: Float
    ): GameEnvironmentBuilder {
        this.frequency = frequency
        return this
    }

    fun setTimeOfDay(timeOfDay: TimeOfDay): GameEnvironmentBuilder {
        this.timeOfDay = timeOfDay
        return this
    }

    fun setScene(scene: Scene): GameEnvironmentBuilder {
        this.scene = scene
        return this
    }

    fun build(): GameEnvironment {
        return GameEnvironment(quality, frequency, timeOfDay, scene)
    }

}

enum class TimeOfDay {
    MORNING, NOON, AFTERNOON, EVENING, NIGHT
}

enum class Scene {
    FOREST, CITY, CAVE, BARRACKS, CLUB
}

enum class RenderQuality {
    LOW, MEDIUM, MAX, ULTRA
}

data class GameEnvironment(
    val quality: RenderQuality,
    val frequencyOfRocks: Float,
    val timeOfDay: TimeOfDay,
    val scene: Scene
)
