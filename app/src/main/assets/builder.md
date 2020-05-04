<pre>
<code>
<span class="keyword">class</span> GameEnvironmentBuilder {

    <span class="keyword">var</span> quality = RenderQuality.<span class="static">MEDIUM</span>
    <span class="keyword">var</span> frequency = <span class="literals">0.0f</span>
    <span class="keyword">var</span> timeOfDay = TimeOfDay.<span class="static">MORNING</span>
    <span class="keyword">var</span> scene = Scene.<span class="static">BARRACKS</span>

    <span class="keyword">fun</span> setRenderQuality(quality: RenderQuality): <span class="types">GameEnvironmentBuilder</span> {
        <span class="keyword">this</span>.quality = quality
        <span class="keyword">return this</span>
    }

    <span class="keyword">fun</span> setRocksFrequency(
        <span class="annotation">@FloatRange(from = 0.0, to = 1.0)</span> frequency: <span class="types">Float</span>
    ): <span class="types">GameEnvironmentBuilder</span> {
        <span class="keyword">this</span>.frequency = frequency
        <span class="keyword">return this</span>
    }

    <span class="keyword">fun</span> setTimeOfDay(timeOfDay: <span class="types">TimeOfDay</span>): <span class="types">GameEnvironmentBuilder</span> {
        <span class="keyword">this</span>.timeOfDay = timeOfDay
        <span class="keyword">return this</span>
    }

    <span class="keyword">fun</span> setScene(scene: <span class="types">Scene</span>): <span class="types">GameEnvironmentBuilder</span> {
        <span class="keyword">this</span>.scene = scene
        <span class="keyword">return this</span>
    }

    <span class="keyword">fun</span> build(): <span class="types">GameEnvironment</span> {
        <span class="keyword">return</span> GameEnvironment(quality, frequency, timeOfDay, scene)
    }

}

<span class="keyword">enum class</span> TimeOfDay {
    MORNING, NOON, AFTERNOON, EVENING, NIGHT
}

<span class="keyword">enum class</span> Scene {
    FOREST, CITY, CAVE, BARRACKS, CLUB
}

<span class="keyword">enum class</span> RenderQuality {
    LOW, MEDIUM, MAX, ULTRA
}

<span class="keyword">data class</span> GameEnvironment(
    <span class="keyword">val</span> quality: <span class="types">RenderQuality</span>,
    <span class="keyword">val</span> frequencyOfRocks: <span class="types">Float</span>,
    <span class="keyword">val</span> timeOfDay: <span class="types">TimeOfDay</span>,
    <span class="keyword">val</span> scene: <span class="types">Scene</span>
)

//DSL Format
<span class="keyword">fun</span> createEnvironment(init: <span class="types">GameEnvironmentBuilder.() -> Unit</span>): <span class="types">GameEnvironment</span> {
    <span class="keyword">val</span> gameEnvironmentBuilder = GameEnvironmentBuilder()
    init(gameEnvironmentBuilder)
    <span class="keyword">return</span> gameEnvironmentBuilder.build()
}

<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> gv = GameEnvironmentBuilder().run {
                setRenderQuality(RenderQuality.ULTRA)
                setRocksFrequency(0.8f)
                setScene(Scene.CLUB)
                setTimeOfDay(TimeOfDay.MORNING)
                build()
             }

    <span class="comment">//DSL Format</span>
    <span class="keyword">val</span> gvDsl = createEnvironment {
                  frequency = 0.3f
                  quality = RenderQuality.MEDIUM
                  timeOfDay = TimeOfDay.MORNING
                  scene = Scene.CITY
                }

    <span class="assertions">assert</span>(gv.quality == RenderQuality.ULTRA)
    <span class="assertions">assert</span>(gvDsl.quality == RenderQuality.MEDIUM)
}
</code>
</pre>