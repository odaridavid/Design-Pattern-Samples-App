<pre>
<code>
<span class="keyword">interface</span> FurnitureTheme {
    <span class="keyword">fun</span> getTheme(): <span class="types">String</span>
}

<span class="keyword">class</span> VintageFurniture : FurnitureTheme {
    <span class="keyword">override fun</span> getTheme(): <span class="types">String</span> = <span class="string">"Vintage"</span>
}

<span class="keyword">abstract class</span> Furniture(<span class="keyword">val</span> furnitureTheme: FurnitureTheme) {
    <span class="keyword">abstract fun</span> getType(): <span class="types">String</span>
}

<span class="keyword">class</span> Chair(<span class="keyword">private val</span> theme: FurnitureTheme) : Furniture(theme) {
    <span class="keyword">override fun</span> getType(): <span class="types">String</span> = <span class="string">"<span class="string-template">${theme.getTheme()}</span> Chair."</span>
}

<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> theme = VintageFurniture()
    <span class="keyword">val</span> chair = Chair(theme)

    <span class="assertions">assert</span>(chair.getType().<span class="stdlib">contains</span>(<span class="string">"Vintage Chair"</span>))
}
</code>
</pre>