/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns.command

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