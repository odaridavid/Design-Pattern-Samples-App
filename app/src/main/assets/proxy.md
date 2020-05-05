<pre>
<code>
<span class="keyword">interface</span> Car {
    <span class="keyword">fun</span> drive(): <span class="types">String</span>
}

<span class="keyword">class</span> RealCar : Car {
    <span class="keyword">override fun</span> drive(): <span class="types">String</span> {
        <span class="keyword">return</span> <span class="string">"Ignition On"</span>
    }
}

<span class="keyword">class</span> ProxyCar : Car {
    <span class="keyword">private val</span> realCar = RealCar()
    <span class="keyword">var</span> key = <span class="string">"none"</span>

    <span class="keyword">override fun</span> drive(): <span class="types">String</span> {
        <span class="keyword">return if</span> (key == <span class="string">"none"</span>)
            <span class="string">"No keys available"</span>
        <span class="keyword">else</span> realCar.drive()
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> proxyCar = ProxyCar()
    <span class="assertions">assert</span>(proxyCar.drive()<span class="stdlib">.contains</span>(<span class="string">"No keys available"</span>))

    proxyCar.key = <span class="string">"available"</span>
    <span class="assertions">assert</span>(proxyCar.drive()<span class="stdlib">.contains</span>(<span class="string">"Ignition On"</span>))
}
</code>
</pre>