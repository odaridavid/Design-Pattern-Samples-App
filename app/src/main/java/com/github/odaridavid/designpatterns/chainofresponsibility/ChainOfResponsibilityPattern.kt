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
package com.github.odaridavid.designpatterns.chainofresponsibility

//TODO Revisit chain of responsibility
interface Processing {
    var process: String
    fun processProduct(next: Processing): Processing
}

abstract class BaseProcessing(override var process: String, var next: Processing? = null) :
    Processing {

    override fun processProduct(next: Processing): Processing {
        this.next = next
        println("From $process")
        println("To ${next.process}")
        return this
    }

}

class ConvertRawMaterial : BaseProcessing("Convert Raw Material")

class Packaging : BaseProcessing("Packaging")

class Labeling : BaseProcessing("Labeling")



