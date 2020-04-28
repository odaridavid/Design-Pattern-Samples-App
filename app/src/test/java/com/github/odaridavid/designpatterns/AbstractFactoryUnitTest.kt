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

import com.github.odaridavid.designpatterns.abstractfactory.*
import org.junit.BeforeClass
import org.junit.Test

class AbstractFactoryUnitTest {

    @Test
    fun getTruck_simpleCarFactory_returnsIsuzu() {
        assert(simpleCarFactory.getTruck() is Isuzu)
    }

    @Test
    fun getTruck_sophisticatedCarFactory_returnsBenz() {
        assert(sophisticatedCarFactory.getTruck() is Benz)
    }

    @Test
    fun getSaloon_simpleCarFactory_returnsNissan() {
        assert(simpleCarFactory.getSaloon() is Nissan)
    }

    @Test
    fun getSaloon_sophisticatedCarFactory_returnsBently() {
        assert(sophisticatedCarFactory.getSaloon() is Bently)
    }

    @Test
    fun getSUV_simpleCarFactory_returnsHarrier() {
        assert(simpleCarFactory.getSUV() is Harrier)
    }

    @Test
    fun getSUV_sophisticatedCarFactory_returnsHummer() {
        assert(sophisticatedCarFactory.getSUV() is Hummer)
    }

    companion object {
        lateinit var simpleCarFactory: CarFactory
        lateinit var sophisticatedCarFactory: CarFactory

        @JvmStatic
        @BeforeClass
        fun setup() {
            simpleCarFactory = CarFactory.createCarFactory<SimpleCarFactory>()
            sophisticatedCarFactory = CarFactory.createCarFactory<SophisticatedCarFactory>()
        }
    }
}