<pre>
<code>
<span class="keyword">data class</span> Memento(<span class="keyword">val</span> state: <span class="types">String</span>)

<span class="keyword">class</span> Originator(<span class="keyword">var</span> state: <span class="types">String</span>) {

    <span class="keyword">fun</span> saveToMemento(): <span class="types">Memento</span> {
        <span class="keyword">return</span> Memento(state)
    }

    <span class="keyword">fun</span> restoreFromMemento(memento: <span class="keyword">Memento</span>) {
        state = memento.state
    }
}

<span class="keyword">class</span> CareTaker {
    <span class="keyword">private val</span> savedStates = <span class="keyword">ArrayList</span><<span class="types">Memento</span>>()

    <span class="keyword">fun</span> saveState(state: <span class="types">Memento</span>) {
        savedStates.add(state)
    }

    <span class="keyword">fun</span> restore(index: <span class="types">Int</span>): <span class="types">Memento</span> {
        <span class="keyword">return</span> savedStates[index]
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> originator = Originator(state = <span class="string">"Start State"</span>)
    <span class="keyword">val</span> careTaker = CareTaker()
    careTaker.saveState(originator.saveToMemento())

    originator.state = <span class="string">"Second State"</span>
    careTaker.saveState(originator.saveToMemento())

    originator.state = <span class="string">"Third State"</span>
    originator.state =<span class="string">"Fourth State"</span>
    careTaker.saveState(originator.saveToMemento())
    <span class="assertions">assert</span>(originator.state == <span class="string">"Fourth State"</span>)

    originator.restoreFromMemento(careTaker.restore(<span class="literals">0</span>))
    <span class="assertions">assert</span>(originator.state == <span class="string">"Start State"</span>)
}
</code>
</pre>