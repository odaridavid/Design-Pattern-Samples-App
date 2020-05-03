<pre>
<code>
interface Race {
    fun race() {
        println("Take off!!")
    }
}

class FerrariRace : Race
class BMWRace : Race

class RaceEvent : Race {
    private var raceCars = mutableListOf<Race>()

    fun registerCar(race: Race) {
        raceCars.add(race)
    }

    fun deregisterCar(race: Race) {
        raceCars.remove(race)
    }

    override fun race() {
        for (raceCar in raceCars) {
            raceCar.race()
        }
    }
}

</code>
</pre>