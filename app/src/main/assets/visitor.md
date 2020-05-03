<pre>
<code>
interface Visitor {
    fun visit(hotel: Hotel)
    fun visit(lodging: Lodging)
    fun visit(airBnb: AirBnb)
}

interface Accomodation {
    val rating: Int
    fun accept(visitor: Visitor)
}

class AccomodationVisitor : Visitor {

    override fun visit(hotel: Hotel) {
        println("Hotel rating on visit ${hotel.rating}")
    }

    override fun visit(lodging: Lodging) {
        println("Lodging rating on visit ${lodging.rating}")
    }

    override fun visit(airBnb: AirBnb) {
        println("Airbnb rating on visit ${airBnb.rating}")
    }

}

class Hotel(override val rating: Int) : Accomodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Lodging(override val rating: Int) : Accomodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class AirBnb(override val rating: Int) : Accomodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}
</code>
</pre>