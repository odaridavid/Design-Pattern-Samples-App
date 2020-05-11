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
package com.github.odaridavid.designpatterns

import com.github.odaridavid.designpatterns.patterns.flyweight.GameSceneFactory
import com.github.odaridavid.designpatterns.patterns.flyweight.TimeOfDay
import org.junit.Test

internal class FlyweightPatternUnitTest {

    @Test
    fun gameScenes_flyweightPattern() {
        //Initial
        assert(GameSceneFactory.getNoOfStoredScenes() == 0)

        //Store 2 objects
        GameSceneFactory.getCityScene(TimeOfDay.AFTERNOON)
        GameSceneFactory.getForestScene(TimeOfDay.NIGHT)
        assert(GameSceneFactory.getNoOfStoredScenes() == 2)

        //Re-use one object
        GameSceneFactory.getCityScene(TimeOfDay.AFTERNOON)
        assert(GameSceneFactory.getNoOfStoredScenes() == 2)
    }
}