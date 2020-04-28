package com.github.odaridavid.designpatterns

import com.github.odaridavid.designpatterns.builder.GameEnvironmentBuilder
import com.github.odaridavid.designpatterns.builder.RenderQuality
import com.github.odaridavid.designpatterns.builder.Scene
import com.github.odaridavid.designpatterns.builder.TimeOfDay
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

        assert(gv.quality == RenderQuality.ULTRA)
        assert(gv1.quality == RenderQuality.LOW)
    }

}