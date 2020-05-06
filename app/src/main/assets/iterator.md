<pre>
<code>
<span class="keyword">interface</span> Iterator {
    <span class="keyword">val</span> next: <span class="types">Car?</span>
    <span class="keyword">fun</span> hasNext(): <span class="types">Boolean</span>
}

<span class="keyword">interface</span> Container {
    <span class="keyword">fun</span> createIterator(): <span class="types">Iterator</span>
}

<span class="keyword">class</span> Car(<span class="keyword">val</span> name: <span class="string">String</span>)

<span class="keyword">class</span> CarIterator(<span class="keyword">private val</span> cars: <span class="stdlib">Array</span><<span class="types">Car</span>>) : Iterator {

    <span class="keyword">var</span> index: <span class="types">Int</span> = <span class="literals">0</span>

    <span class="keyword">override val</span> next: <span class="types">Car?</span>
        <span class="keyword">get</span>() {
            <span class="keyword">val</span> car = cars[index]
            index++
            <span class="keyword">return</span> car
        }

    <span class="keyword">override fun</span> hasNext(): <span class="types">Boolean</span> = index < cars.size

}

<span class="keyword">class</span> CarCollection : Container {

    <span class="keyword">override fun</span> createIterator(): <span class="types">Iterator</span> {
        <span class="keyword">val</span> cars = <span class="stdlib">arrayOf</span>(Car(<span class="string">"BMW"</span>), Car(<span class="string">"Tesla"</span>), Car(<span class="string">"Maserati"</span>))
        <span class="keyword">return</span> CarIterator(cars)
    }

}

<span class="keyword">class</span> CarShowroom(<span class="keyword">private val</span> carCollection: <span class="types">CarCollection</span> = CarCollection()) {
    <span class="keyword">fun</span> showcaseCars() {
        <span class="keyword">val</span> iterator = carCollection.createIterator()
        <span class="keyword">while</span> (iterator.hasNext()) {
            <span class="stdlib">println</span>(<span class="string">"We have <span class="string-template">${iterator.next?.name}</span>"</span>)
        }
    }
}

<span class="keyword">fun</span> main() {
    CarShowroom().showcaseCars()

    <span class="comments">//prints
    We have BMW
    We have Tesla
    We have Maserati</span>
}
</code>
</pre>