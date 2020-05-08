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
package com.github.odaridavid.designpatterns.patterns.templatemethod

internal abstract class Window {
    abstract fun getWidth(): Float
    abstract fun getHeight(): Float
    abstract fun render(height: Float, width: Float)
    fun draw() {
        render(getHeight(), getWidth())
    }
}

internal class RectangularWindow : Window() {
    override fun getWidth(): Float = 1024.0f

    override fun getHeight(): Float = 512.0f

    override fun render(height: Float, width: Float) {
        println("Rendering window of $height pixels by $width pixels")
    }
}