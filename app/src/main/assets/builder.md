<pre>
<code>
<span class="keyword">class</span> GameEnvironmentBuilder {

    <span class="keyword">private var</span> quality = RenderQuality.<span class="static">MEDIUM</span>
    <span class="keyword">private var</span> frequency = <span class="literals">0.0f</span>
    <span class="keyword">private var</span> timeOfDay = TimeOfDay.<span class="static">MORNING</span>
    <span class="keyword">private var</span> scene = Scene.<span class="static">BARRACKS</span>

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
    <span class="static">MORNING, NOON, AFTERNOON, EVENING, NIGHT</span>
}

<span class="keyword">enum class</span> Scene {
    <span class="static">FOREST, CITY, CAVE, BARRACKS, CLUB</span>
}

<span class="keyword">enum class</span> RenderQuality {
    <span class="static">LOW, MEDIUM, MAX, ULTRA</span>
}

<span class="keyword">data class</span> GameEnvironment(
    <span class="keyword">val</span> quality: <span class="types">RenderQuality</span>,
    <span class="keyword">val</span> frequencyOfRocks: <span class="types">Float</span>,
    <span class="keyword">val</span> timeOfDay: <span class="types">TimeOfDay</span>,
    <span class="keyword">val</span> scene: <span class="types">Scene</span>
)

<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> gv = GameEnvironmentBuilder().<span class="stdlib">run</span> {
                setRenderQuality(RenderQuality.<span class="static">ULTRA</span>)
                setRocksFrequency(<span class="literals">0.8f</span>)
                setScene(Scene.<span class="static">CLUB</span>)
                setTimeOfDay(TimeOfDay.<span class="static">MORNING</span>)
                build()
             }

    <span class="assertions">assert</span>(gv.quality == RenderQuality.<span class="static">ULTRA</span>)
}
</code>
</pre>