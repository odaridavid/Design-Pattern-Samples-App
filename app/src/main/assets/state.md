<pre>
<code>

sealed class DoorState

object Open : DoorState()
object Closed : DoorState()

class Door {
    private var doorState: DoorState = Closed

    fun open() {
        doorState = Open
    }

    fun close() {
        doorState = Closed
    }

    fun enter(): String {
        return when (doorState) {
            is Open -> "Welcome"
            is Closed -> "Can't get in"
        }
    }
}
</code>
</pre>