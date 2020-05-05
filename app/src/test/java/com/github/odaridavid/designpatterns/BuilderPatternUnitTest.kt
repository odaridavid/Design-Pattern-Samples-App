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

import com.github.odaridavid.designpatterns.builder.GameEnvironmentBuilder
import com.github.odaridavid.designpatterns.builder.RenderQuality
import com.github.odaridavid.designpatterns.builder.Scene
import com.github.odaridavid.designpatterns.builder.TimeOfDay
import org.junit.Test

class BuilderPatternUnitTest {

    @Test
    fun build_returnGameEnvironment() {
        val gv = GameEnvironmentBuilder().run {
            setRenderQuality(RenderQuality.ULTRA)
            setRocksFrequency(0.8f)
            setScene(Scene.CLUB)
            setTimeOfDay(TimeOfDay.MORNING)
            build()
        }

        assert(gv.quality == RenderQuality.ULTRA)
    }

}