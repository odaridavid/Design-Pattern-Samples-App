<pre>
<code>
interface Command {
    fun execute()
}

class Race {
    private val queue = ArrayList<Command>()

    fun register(command: Command) {
        queue.add(command)
    }

    fun execute() {
        for (command in queue) {
            command.execute()
        }
    }

}

class RaceCommand(private val event: Event) : Command {
    override fun execute() {
        event.beginRace()
    }
}

class DetourCommand(private val event: Event) : Command {
    override fun execute() {
        event.takeDetour()
    }
}

class Event {
    fun beginRace() {
        println("Racing Begins")
    }

    fun takeDetour() {
        println("Changing track")
    }
}
</code>
</pre>