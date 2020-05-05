<pre>
<code>
<span class="keyword">sealed class</span> DoorState

<span class="keyword">object</span> Open : DoorState()
<span class="keyword">object</span> Closed : DoorState()

<span class="keyword">class</span> Door {
    <span class="keyword">private var</span> doorState: <span class="types">DoorState</span> = Closed

    <span class="keyword">fun</span> open() {
        doorState = Open
    }

    <span class="keyword">fun</span> close() {
        doorState = Closed
    }

    <span class="keyword">fun</span> enter(): <span class="types">String</span> {
        <span class="keyword">return when</span> (doorState) {
            <span class="keyword">is</span> Open -> <span class="string">"Welcome"</span>
            <span class="keyword">is</span> Closed -> <span class="string">"Can't get in"</span>
        }
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> door = Door()
    <span class="assertions">assert</span>(door.enter().<span class="stdlib">contains</span>(<span class="string">"Can't get in"</span>))

    door.open()
    <span class="assertions">assert</span>(door.enter().<span class="stdlib">contains</span>(<span class="string">"Welcome"</span>))

    door.close()
}
</code>
</pre>