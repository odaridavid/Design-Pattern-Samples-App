package com.github.odaridavid.designpatterns

import org.junit.Test

class AbstractFactoryUnitTest {

    @Test
    fun getTruck_simpleCarFactory_returnsIsuzu() {
        assert(SimpleCarFactory().getTruck() is Isuzu)
    }

    @Test
    fun getTruck_sophisticatedCarFactory_returnsBenz() {
        assert(SophisticatedCarFactory().getTruck() is Benz)
    }

    @Test
    fun getSaloon_simpleCarFactory_returnsNissan() {
        assert(SimpleCarFactory().getSaloon() is Nissan)
    }

    @Test
    fun getSaloon_sophisticatedCarFactory_returnsBently() {
        assert(SophisticatedCarFactory().getSaloon() is Bently)
    }

    @Test
    fun getSUV_simpleCarFactory_returnsHarrier() {
        assert(SimpleCarFactory().getSUV() is Harrier)
    }

    @Test
    fun getSUV_sophisticatedCarFactory_returnsHummer() {
        assert(SophisticatedCarFactory().getSUV() is Hummer)
    }
}