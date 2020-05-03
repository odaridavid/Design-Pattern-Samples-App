<pre>
<code>
<span class="keyword">interface</span> Truck {
   <span class="keyword">val</span> color: <span class="types">String</span>
   <span class="keyword">fun</span> noOfWheels(): <span class="types">Int</span>
}

<span class="keyword">class</span> Isuzu(<span class="keyword">override val</span> color: <span class="types">String</span>) : Truck {
    <span class="keyword">override fun</span> noOfWheels(): <span class="types">Int</span> = 18
}

<span class="keyword">class</span> Benz(<span class="keyword">override val</span> color: String) : Truck {
   <span class="keyword">override fun</span> noOfWheels(): <span class="types">Int</span> = 22
}

<span class="keyword">class</span> JapanTruckFactory : CarFactory() {
    <span class="keyword">override fun</span> getTruck(): <span class="types">Truck</span> = Isuzu(<span class="arguments">color</span> = <span class="string">"White"</span>)
}

<span class="keyword">class</span> GermanTruckFactory : CarFactory() {
    <span class="keyword">override fun</span> getTruck(): <span class="types">Truck</span> = Benz(<span class="arguments">color</span> = <span class="string">"Black"</span>)
}

<span class="keyword">abstract class</span> CarFactory {

    <span class="keyword">abstract fun</span> getTruck(): <span class="types">Truck</span>

    <span class="keyword">companion object</span> {

        <span class="annotation">@JvmStatic</span>
        <span class="keyword">inline fun</span> <<span class="keyword">reified</span> <span class="generic">T</span>> createTruckFactory(): CarFactory {
            <span class="keyword">return when</span> (<span class="generic">T</span>::<span class="keyword">class</span>) {
                JapanTruckFactory::<span class="keyword">class</span> -> JapanTruckFactory()
                GermanTruckFactory::<span class="keyword">class</span> -> GermanTruckFactory()
                <span class="keyword">else</span> -> <span class="keyword">throw</span> IllegalStateException(<span class="string">"Unidentified truck factory"</span>)
            }
        }

    }
}

</code>
</pre>