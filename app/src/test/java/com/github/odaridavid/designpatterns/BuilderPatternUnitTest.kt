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