<pre>
<code>
<span class="keyword">interface</span> Visitor {
    <span class="keyword">fun</span> visit(hotel: <span class="types">Hotel</span>)
    <span class="keyword">fun</span> visit(lodging: <span class="types">Lodging</span>)
    <span class="keyword">fun</span> visit(airBnb: <span class="types">AirBnb</span>)
}

<span class="keyword">interface</span> Accommodation {
    <span class="keyword">val</span> rating: <span class="types">Int</span>
    <span class="keyword">fun</span> accept(visitor: <span class="types">Visitor</span>)
}

<span class="keyword">class</span> AccommodationVisitor : Visitor {

    <span class="keyword">override fun</span> visit(hotel: <span class="types">Hotel</span>) {
        <span class="stdlib">println</span>(<span class="string">"Hotel score on visit <span class="string-template">${hotel.rating / 10 * 100}</span>"</span>)
    }

    <span class="keyword">override fun</span> visit(lodging: <span class="types">Lodging</span>) {
        <span class="stdlib">println</span>(<span class="string">"Lodging score on visit <span class="string-template">${lodging.rating / 10 * 100}</span>"</span>)
    }

    <span class="keyword">override fun</span> visit(airBnb: <span class="types">AirBnb</span>) {
        <span class="stdlib">println</span>(<span class="string">"AirBnb score on visit <span class="string-template">${airBnb.rating / 10 * 100}</span>"</span>)
    }

}

<span class="keyword">class</span> Hotel(<span class="keyword">override val</span> rating: <span class="types">Int</span>) : Accommodation {
    <span class="keyword">override fun</span> accept(visitor: <span class="types">Visitor</span>) {
        visitor.visit(<span class="keyword">this</span>)
    }
}

<span class="keyword">class</span> Lodging(<span class="keyword">override val</span> rating: <span class="types">Int</span>) : Accommodation {
    <span class="keyword">override fun</span> accept(visitor: <span class="types">Visitor</span>) {
        visitor.visit(<span class="keyword">this</span>)
    }
}

<span class="keyword">class</span> AirBnb(<span class="keyword">override val</span> rating: <span class="types">Int</span>) : Accommodation {
    <span class="keyword">override fun</span> accept(visitor: <span class="types">Visitor</span>) {
        visitor.visit(<span class="keyword">this</span>)
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> visitor = AccommodationVisitor()

    <span class="keyword">val</span> hotel = Hotel(<span class="arguments">rating</span> = <span class="literals">4</span>)
    <span class="keyword">val</span> lodging = Lodging(<span class="arguments">rating</span> = <span class="literals">9</span>)
    <span class="keyword">val</span> airBnb = AirBnb(<span class="arguments">rating</span> = <span class="literals">5</span>)

    airBnb.accept(visitor)
    hotel.accept(visitor)
    lodging.accept(visitor)
}
</code>
</pre>