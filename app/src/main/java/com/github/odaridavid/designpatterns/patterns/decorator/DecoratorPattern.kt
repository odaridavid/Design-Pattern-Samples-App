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
package com.github.odaridavid.designpatterns.patterns.decorator


internal interface Bar {
    fun setup()
}

internal class CollegeBar : Bar {
    override fun setup() {
        println("College Bar Setup")
    }
}

internal class SportsBar : Bar {
    override fun setup() {
        println("Sports Bar Setup")
    }
}

internal abstract class BarDecorator(bar: Bar) : Bar by bar

internal class HalloweenBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Halloween Ornaments")
    }
}

internal class ChristmasBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Christmas Ornaments")
    }
}