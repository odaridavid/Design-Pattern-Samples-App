<pre>
<code>
<span class="keyword">interface</span> OrderHandler {
    <span class="keyword">val</span> nextHandler: <span class="types">OrderHandler?</span>
    <span class="keyword">fun</span> handleRequest(order: <span class="types">Order</span>)
}

<span class="keyword">interface</span> Order {
    <span class="keyword">val</span> items: <span class="stdlib">Map</span><<span class="types">String, Int</span>>
}

<span class="keyword">class</span> IceCreamOrder(<span class="keyword">override val</span> items: <span class="stdlib">Map</span><<span class="types">String, Int</span>>) : Order

<span class="keyword">class</span> IceCreamVendor(<span class="keyword">override val</span> nextHandler: OrderHandler?) : OrderHandler {
    <span class="keyword">override fun</span> handleRequest(order: <span class="types">Order</span>) {
        <span class="keyword">val</span> orderSize = order.items.values.<span class="stdlib">sum()</span>
        <span class="keyword">if</span> (orderSize > <span class="literals">5</span>) {
            <span class="stdlib">println</span>(<span class="string">"Vendor: I'll have to get some"</span>)
            nextHandler?.handleRequest(order) ?: <span class="keyword">return</span>
        } <span class="keyword">else</span> {
            <span class="stdlib">println</span>(<span class="string">"Order of <span class="string-template">${order.items.keys}</span> coming right up"</span>)
        }
    }
}

<span class="keyword">class</span> IceCreamRetailer(<span class="keyword">override val</span> nextHandler: OrderHandler?) : OrderHandler {
    <span class="keyword">override fun</span> handleRequest(order: <span class="types">Order</span>) {
        <span class="keyword">val</span> orderSize = order.items.values.<span class="stdlib">sum()</span>
        <span class="keyword">if</span> (orderSize > <span class="literals">10</span>) {
            <span class="stdlib">println</span>(<span class="string">"Retailer: Hmm guess I'll have to order more too"</span>)
            nextHandler?.handleRequest(order) ?: <span class="keyword">return</span>
        } <span class="keyword">else</span> {
            <span class="stdlib">println</span>(<span class="string">"Order of <span class="string-template">${order.items.keys}</span> enroute to vendor"</span>)
        }
    }
}

<span class="keyword">class</span> IceCreamFactory(<span class="keyword">override val</span> nextHandler: <span class="types">OrderHandler?</span>) : OrderHandler {
    <span class="keyword">override fun</span> handleRequest(order: <span class="types">Order</span>) {
        <span class="keyword">val</span> orderSize = order.items.values.<span class="stdlib">sum()</span>
        <span class="keyword">if</span> (orderSize > <span class="literals">100</span>) {
            nextHandler?.handleRequest(order) ?: <span class="keyword">return</span>
        } <span class="keyword">else</span> {
            <span class="stdlib">println</span>(<span class="string">"Factory: Order of <span class="string-template">${order.items.keys}</span> coming enroute to retailer"</span>)
        }
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> iceCreamFactory = IceCreamFactory(<span class="arguments">nextHandler</span> = <span class="keyword">null</span>)
    <span class="keyword">val</span> iceCreamRetailer = IceCreamRetailer(<span class="arguments">nextHandler</span> = iceCreamFactory)
    <span class="keyword">val</span> iceCreamVendor = IceCreamVendor(<span class="arguments">nextHandler</span> = iceCreamRetailer)

    <span class="keyword">val</span> order = IceCreamOrder(<span class="stdlib">mapOf</span>(<span class="string">"Vanilla"</span> <span class="stdlib">to</span> <span class="literal">10</span>, <span class="string">"Chocolate"</span> <span class="stdlib">to</span> <span class="literals">9</span>, <span class="string">"Pistachio"</span> <span class="stdlib">to</span> <span class="literals">5</span>))
    iceCreamVendor.handleRequest(order)
}
</code>
</pre>