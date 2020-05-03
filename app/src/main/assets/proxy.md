<pre>
<code>
open class Car {
    open fun drive() {
        println("Driving")
    }
}

class ProxyCar : Car() {
    var key = "none"

    override fun drive() {
        super.drive()
        if (key == "none")
            println("No keys to access vehicle")
        else println("Enjoy your drive")
    }
}
</code>
</pre>