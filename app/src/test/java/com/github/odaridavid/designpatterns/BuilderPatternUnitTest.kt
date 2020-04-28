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

import com.github.odaridavid.designpatterns.builder.*
import org.junit.Test

class BuilderPatternUnitTest {

    @Test
    fun build_returnGameEnvironment() {
        val gv1 = GameEnvironmentBuilder
            .setRenderQuality(RenderQuality.LOW)
            .setRocksFrequency(0.4f)
            .setScene(Scene.CAVE)
            .setTimeOfDay(TimeOfDay.AFTERNOON)
            .build()

        val gv = GameEnvironmentBuilder.run {
            setRenderQuality(RenderQuality.ULTRA)
            setRocksFrequency(0.8f)
            setScene(Scene.CLUB)
            setTimeOfDay(TimeOfDay.MORNING)
            build()
        }

        val gvDsl = createEnvironment {
            frequency = 0.3f
            quality = RenderQuality.MEDIUM
            timeOfDay = TimeOfDay.MORNING
            scene = Scene.CITY
        }

        assert(gv.quality == RenderQuality.ULTRA)
        assert(gv1.quality == RenderQuality.LOW)
        assert(gvDsl.quality ==RenderQuality.MEDIUM)
    }

}