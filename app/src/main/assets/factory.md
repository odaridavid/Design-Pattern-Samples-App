<pre>
<code>
open class Kitchen {
    fun setupEquipment() {
        println("Unpacking Equipment")
        println("Setting up...")
        Thread.sleep(2000)
        println("Equipment setup complete")
    }
}

class LShapedKitchen : Kitchen()

class PeninsulaKitchen : Kitchen()

class IslandKitchen : Kitchen()

enum class FloorPlan {
    SPACED, DETACHED, EXTENDING
}

object KitchenFloorFactory {
    inline fun <reified T> getFloorPlan(): FloorPlan {
        return when (T::class) {
            PeninsulaKitchen::class -> FloorPlan.DETACHED
            IslandKitchen::class -> FloorPlan.EXTENDING
            LShapedKitchen::class -> FloorPlan.SPACED
            else -> throw IllegalStateException("Unknown plan selected:No Available Kitchen")//or provide default
        }
    }
}

//Currency Example
sealed class Country

object Uganda : Country()
object Kenya : Country()
object Tanzania : Country()
object Rwanda : Country()

class Currency(val code: String)

object CurrencyFactory {
    fun getCurrency(country: Country): Currency {
        return when (country) {
            is Uganda -> Currency("UG")
            is Kenya -> Currency("KSH")
            is Tanzania -> Currency("TZ")
            is Rwanda -> Currency("RW")
        }
    }
}


</code>
</pre>