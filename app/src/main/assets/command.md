<pre>
<code>
<span class="keyword">interface</span> Command {
    <span class="keyword">fun</span> execute()
}

<span class="keyword">class</span> RaceOrganizer {
    <span class="keyword">private val</span> queue = <span class="stdlib">ArrayList</span><<span class="types">Command</span>>()

    <span class="keyword">fun</span> register(command: <span class="types">Command</span>) {
        queue.add(command)
    }

    <span class="keyword">fun</span> execute() {
        <span class="keyword">for</span> (command <span class="keyword">in</span> queue) {
            command.execute()
        }
    }
}

<span class="keyword">class</span> RaceCommand(<span class="keyword">private val</span> event: <span class="types">Event</span>) : Command {
    <span class="keyword">override fun</span> execute() {
        event.beginRace()
    }
}

<span class="keyword">class</span> DetourCommand(<span class="keyword">private val</span> event: <span class="types">Event</span>) : Command {
    <span class="keyword">override fun</span> execute() {
        event.takeDetour()
    }
}

<span class="keyword">class</span> Event {
    <span class="keyword">fun</span> beginRace() {
        <span class="stdlib">println</span>(<span class="string">"Racing Begins"</span>)
    }

    <span class="keyword">fun</span> takeDetour() {
        <span class="stdlib">println</span>(<span class="string">"Changing track"</span>)
    }
}

<span class="keyword">fun</span> main(){
    <span class="keyword">val</span> event = Event()

    <span class="keyword">val</span> raceCommand = RaceCommand(event)
    <span class="keyword">val</span> detourCommand = DetourCommand(event)

    RaceOrganizer().<span class="stdlib">apply</span> <span class="stdlib">{</span>
        register(raceCommand)
        register(detourCommand)
        execute()
    <span class="stdlib">}</span>
}
</code>
</pre>