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
package com.github.odaridavid.designpatterns.patterns.flyweight

import java.util.*

internal interface GameScene {
    val timeOfDay: TimeOfDay
    fun render()
}

internal enum class TimeOfDay {
    MORNING, AFTERNOON, NIGHT
}

internal class CityScene(override val timeOfDay: TimeOfDay) : GameScene {
    override fun render() {
        println("Entering City")
    }
}

internal class ForestScene(override val timeOfDay: TimeOfDay) : GameScene {
    override fun render() {
        println("Entering Forest")
    }
}

internal object GameSceneFactory {
    private val scenesMap = WeakHashMap<String, GameScene>()

    fun getCityScene(timeOfDay: TimeOfDay): GameScene {
        val key = "CityScene-$timeOfDay"
        return synchronized(this) {
            val scene = scenesMap[key]
            if (scene != null)
                scene
            else {
                val newScene = CityScene(timeOfDay)
                scenesMap[key] = newScene
                newScene
            }
        }
    }

    fun getForestScene(timeOfDay: TimeOfDay): GameScene {
        val key = "ForestScene-$timeOfDay"
        return synchronized(this) {
            val scene = scenesMap[key]
            if (scene != null)
                scene
            else {
                val newScene = ForestScene(timeOfDay)
                scenesMap[key] = newScene
                newScene
            }
        }
    }

    fun getNoOfStoredScenes() = scenesMap.size
}