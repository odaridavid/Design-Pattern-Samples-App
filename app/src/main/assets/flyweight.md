<pre>
<code>
<span class="keyword">interface</span> GameScene {
    <span class="keyword">val</span> timeOfDay: <span class="types">TimeOfDay</span>
    <span class="keyword">fun</span> render()
}

<span class="keyword">enum class</span> TimeOfDay {
    <span class="static">MORNING, AFTERNOON, NIGHT</span>
}

<span class="keyword">class</span> CityScene(<span class="keyword">override val</span> timeOfDay: <span class="types">TimeOfDay</span>) : GameScene {
    <span class="keyword">override fun</span> render() {
        <span class="stdlib">println</span>(<span class="string">"Entering City"</span>)
    }
}

<span class="keyword">class</span> ForestScene(<span class="keyword">override val</span> timeOfDay: <span class="types">TimeOfDay</span>) : GameScene {
    <span class="keyword">override fun</span> render() {
        <span class="stdlib">println</span>(<span class="string">"Entering Forest"</span>)
    }
}

<span class="keyword">object</span> GameSceneFactory {
    <span class="keyword">private val</span> scenesMap = <span class="stdlib">WeakHashMap</span><<span class="types">String, GameScene</span>>()

    <span class="keyword">fun</span> getCityScene(timeOfDay: <span class="types">TimeOfDay</span>): <span class="types">GameScene</span> {
        <span class="keyword">val</span> key = <span class="string">"CityScene-<span class="string-template">$timeOfDay</span>"</span>
        <span class="keyword">return synchronized(this)</span> {
            <span class="keyword">val</span> scene = scenesMap[key]
            <span class="keyword">if</span> (scene != <span class="keyword">null</span>)
                scene
            <span class="keyword">else</span> {
                <span class="keyword">val</span> newScene = CityScene(timeOfDay)
                scenesMap[key] = newScene
                newScene
            }
        }
    }

    <span class="keyword">fun</span> getForestScene(timeOfDay: <span class="keyword">TimeOfDay</span>): <span class="types">GameScene</span> {
        <span class="keyword">val</span> key = <span class="string">"ForestScene-<span class="string-template">$timeOfDay</span>"</span>
        <span class="keyword">return synchronized(this)</span> {
            <span class="keyword">val</span> scene = scenesMap[key]
            <span class="keyword">if</span> (scene != <span class="keyword">null</span>)
                scene
            <span class="keyword">else</span> {
                <span class="keyword">val</span> newScene = ForestScene(timeOfDay)
                scenesMap[key] = newScene
                newScene
            }
        }
    }

    <span class="keyword">fun</span> getNoOfStoredScenes() = scenesMap<span class="stdlib">.size</span>
}

<span class="keyword">fun</span> main() {
    <span class="comments">//Initial</span>
    <span class="assert">assert</span>(GameSceneFactory.getNoOfStoredScenes() == <span class="literals">0</span>)

    <span class="comments">//Store 2 objects</span>
    GameSceneFactory.getCityScene(TimeOfDay.<span class="static">AFTERNOON</span>)
    GameSceneFactory.getForestScene(TimeOfDay.<span class="static">NIGHT</span>)
    <span class="assertions">assert</span>(GameSceneFactory.getNoOfStoredScenes() == <span class="literals">2</span>)

    <span class="comments">//Re-use one object</span>
    GameSceneFactory.getCityScene(TimeOfDay.<span class="static">AFTERNOON</span>)
    <span class="assert">assert</span>(GameSceneFactory.getNoOfStoredScenes() == <span class="literals">2</span>)
}
</code>
</pre>