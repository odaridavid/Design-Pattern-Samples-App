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
package com.github.odaridavid.designpatterns

import com.github.odaridavid.designpatterns.patterns.memento.CareTaker
import com.github.odaridavid.designpatterns.patterns.memento.Originator
import org.junit.Test


class MementoPatternUnitTest {

    @Test
    fun savingStates_mementoPattern() {
        val originator = Originator(state = "Start State")
        val careTaker = CareTaker()
        careTaker.saveState(originator.saveToMemento())

        originator.state = "Second State"
        careTaker.saveState(originator.saveToMemento())

        originator.state = "Third State"
        originator.state = "Fourth State"
        careTaker.saveState(originator.saveToMemento())
        assert(originator.state == "Fourth State")

        originator.restoreFromMemento(careTaker.restore(0))
        assert(originator.state == "Start State")
    }

}