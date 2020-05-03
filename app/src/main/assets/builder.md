<pre>
<code>
//With constructor
class PizzaBuilder(
    private var type: PizzaType = PizzaType.BEEF,
    private var size: PizzaSize = PizzaSize.SMALL,
    private var extraCheese: Boolean = false
) {
    fun build(): Pizza {
        return Pizza(type, size, extraCheese)
    }
}

data class Pizza(val pizzaType: PizzaType, val pizzaSize: PizzaSize, val extraCheese: Boolean)

enum class PizzaSize {
    SMALL, MEDIUM, LARGE
}

enum class PizzaType {
    CHICAGO_STYLE, VEGETABLE, BEEF
}

//Builder methods
object GameEnvironmentBuilder {

    var quality = RenderQuality.MEDIUM
    var frequency = 0.0f
    var timeOfDay = TimeOfDay.MORNING
    var scene = Scene.BARRACKS

    fun setRenderQuality(quality: RenderQuality): GameEnvironmentBuilder {
        this.quality = quality
        return this
    }

    fun setRocksFrequency(
        @FloatRange(from = 0.0, to = 1.0) frequency: Float
    ): GameEnvironmentBuilder {
        this.frequency = frequency
        return this
    }

    fun setTimeOfDay(timeOfDay: TimeOfDay): GameEnvironmentBuilder {
        this.timeOfDay = timeOfDay
        return this
    }

    fun setScene(scene: Scene): GameEnvironmentBuilder {
        this.scene = scene
        return this
    }

    fun build(): GameEnvironment {
        return GameEnvironment(quality, frequency, timeOfDay, scene)
    }

}

enum class TimeOfDay {
    MORNING, NOON, AFTERNOON, EVENING, NIGHT
}

enum class Scene {
    FOREST, CITY, CAVE, BARRACKS, CLUB
}

enum class RenderQuality {
    LOW, MEDIUM, MAX, ULTRA
}

data class GameEnvironment(
    val quality: RenderQuality,
    val frequencyOfRocks: Float,
    val timeOfDay: TimeOfDay,
    val scene: Scene
)

//DSL Format
fun createEnvironment(init: GameEnvironmentBuilder.() -> Unit): GameEnvironment {
    val gameEnvironmentBuilder = GameEnvironmentBuilder
    init(gameEnvironmentBuilder)
    return gameEnvironmentBuilder.build()
}
</code>
</pre>