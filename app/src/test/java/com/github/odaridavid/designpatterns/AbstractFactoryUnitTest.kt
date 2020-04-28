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