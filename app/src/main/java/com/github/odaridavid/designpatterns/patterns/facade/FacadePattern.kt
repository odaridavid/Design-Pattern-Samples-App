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
package com.github.odaridavid.designpatterns.patterns.facade


interface Animator {
    fun animate()
}

interface Interpolator {
    fun interpolate()
}

class SwingAnimator : Animator {
    override fun animate() {
        println("Doing Swing Animation")
    }
}

class LinearInterpolator : Interpolator {
    override fun interpolate() {
        println("Applying Interpolator to animation")
    }
}

class AnimationDirector {
    private val interpolator: Interpolator = LinearInterpolator()
    private val animator: Animator = SwingAnimator()

    fun performAnimations() {
        interpolator.interpolate()
        animator.animate()
    }
}
