<pre>
<code>
interface WaterProvider {
    fun pumpWater(source: String): Water
}

open class OldWaterPump : WaterProvider {
    override fun pumpWater(source: String): Water {
        return Water(source)
    }
}

class WaterFilter {
    fun filterWater(source: String): Water {
        return Water("Filtered $source Water")
    }
}

class WaterFilterAdapter(private val waterFilter: WaterFilter) : OldWaterPump() {

    override fun pumpWater(source: String): Water {
        return waterFilter.filterWater(source)
    }
}

</code>
</pre>