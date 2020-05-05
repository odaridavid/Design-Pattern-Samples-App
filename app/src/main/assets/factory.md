<pre>
<code>
<span class="keyword">sealed class</span> Chair(<span class="keyword">val</span> capacity: <span class="types">Int</span>)

<span class="keyword">class</span> Sofa(capacity: <span class="types">Int</span>) : Chair(capacity)

<span class="keyword">class</span> ParkBench(capacity: <span class="types">Int</span>) : Chair(capacity)

<span class="keyword">object</span> ChairFactory {
    <span class="annotation">@JvmStatic</span>
    <span class="keyword">inline fun <reified <span class="generic">T</span>></span> getChair(): <span class="types">Chair</span> {
        <span class="keyword">return when (<span class="generic">T</span>::class)</span> {
            Sofa::<span class="keyword">class</span> -> Sofa(<span class="literals">5</span>)
            DeskChair::<span class="keyword">class</span> -> DeskChair(<span class="literals">1</span>)
            ParkBench::<span class="keyword">class</span> -> ParkBench(<span class="literals">3</span>)
            <span class="keyword">else</span> -> <span class="keyword">throw</span> IllegalArgumentException(<span class="string">"Unknown type of chair"</span>)
        }
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> sofa = ChairFactory.getChair<<span class="types">Sofa</span>>()
    <span class="keyword">val</span> parkBench = ChairFactory.getChair<<span class="types">ParkBench</span>>()
    <span class="assertions">assert</span>(sofa.capacity == <span class="literals">5</span>)
    <span class="assertions">assert</span>(parkBench.capacity == <span class="literals">3</span>)
}
</code>
</pre>