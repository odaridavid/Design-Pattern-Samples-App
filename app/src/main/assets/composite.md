<pre>
<code>
<span class="keyword">interface</span> Container {
    <span class="keyword">fun</span> extractContent()
}

<span class="keyword">class</span> IceCreamContainer : Container{
    <span class="keyword">override fun</span> extractContent() {
        <span class="stdlib">println</span>(<span class="string">"Ice Cream inside"</span>)
    }
}
<span class="keyword">class</span> MagarineContainer : Container{
    <span class="keyword">override fun</span> extractContent() {
        <span class="stdlib">println</span>(<span class="string">"Magarine Empty"</span>)
    }
}

<span class="keyword">class</span> LargeContainer : Container {
    <span class="keyword">private var</span> containers = mutableListOf<<span class="types">Container</span>>()

    <span class="keyword">fun</span> addContainer(container: <span class="types">Container</span>) {
        containers.add(container)
    }

    <span class="keyword">override fun</span> extractContent() {
        <span class="stdlib">println</span>(<span class="string">"Opened Large Container"</span>)
        <span class="keyword">for</span> (container <span class="keyword">in</span> containers) {
            container.extractContent()
        }
    }

}

<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> largeContainer = LargeContainer()

    largeContainer.addContainer(MagarineContainer())
    largeContainer.addContainer(IceCreamContainer())

    <span class="keyword">val</span> largestContainer = LargeContainer()
    largestContainer.addContainer(largeContainer)

    largestContainer.extractContent()
}
</code>
</pre>