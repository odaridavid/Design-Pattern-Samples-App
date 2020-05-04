<pre>
<code>
<span class="keyword">interface</span> LaptopCable {
    <span class="keyword">fun</span> onConnectedToPowerPort()
}

<span class="keyword">interface</span> PowerBrick {
    <span class="keyword">fun</span> onConnectedToSocket()
}

<span class="keyword">class</span> HpPowerBrick : PowerBrick {
    <span class="keyword">override fun</span> onConnectedToSocket() {
        <span class="stdlib">println</span>(<span class="string">"PowerBrick Receiving Power Supply"</span>)
    }
}

<span class="keyword">open class</span> StockCable : LaptopCable {
    <span class="keyword">override fun</span> onConnectedToPowerPort() {
        <span class="stdlib">println</span>(<span class="string">"Cable Connected To Laptop"</span>)
    }
}

<span class="keyword">class</span> StockCableAdapter(<span class="keyword">private val</span> hpPowerBrick: <span class="types">HpPowerBrick</span>) : StockCable() {
    <span class="keyword">override fun</span> onConnectedToPowerPort() {
        <span class="keyword">super</span>.onConnectedToPowerPort()
        hpPowerBrick.onConnectedToSocket()
        <span class="stdlib">println</span>(<span class="string">"AC/DC Conversion happening"</span>)
    }
}
<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> hpPowerBrick = HpPowerBrick()
    <span class="keyword">val</span> stockCableAdapter = StockCableAdapter(hpPowerBrick)

    stockCableAdapter.onConnectedToPowerPort()
}
</code>
</pre>