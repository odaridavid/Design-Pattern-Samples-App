<pre>
<code>
interface Bar {
    fun open()
    fun close()
    fun executeHappyHour()
    fun setup()
}

class CollegeBar : Bar {
    override fun setup() {
        println("College Bar Setup")
    }

    override fun open() {
        println("College Bar open")
    }

    override fun close() {
        println("College Bar closed")
    }

    override fun executeHappyHour() {
        println("College Bar Happy Hour")
    }
}

class SportsBar : Bar {
    override fun setup() {
        println("Sports Bar Setup")
    }

    override fun open() {
        println("Sports Bar open")
    }

    override fun close() {
        println("Sports Bar closed")
    }

    override fun executeHappyHour() {
        println("Sports Bar Happy Hour")
    }
}

abstract class BarDecorator(bar: Bar) : Bar by bar

class HalloweenBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Halloween Ornaments")
    }
}

class ChristmasBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Christmas Ornaments")
    }
}
</code>
</pre>