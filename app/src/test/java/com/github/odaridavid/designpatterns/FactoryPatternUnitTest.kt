package com.github.odaridavid.designpatterns

import org.junit.Test

class FactoryPatternUnitTest {

    @Test
    fun getCurrency_validCountry_returnsCurrency() {
        assert(CurrencyFactory.getCurrency(Kenya).code == "KSH")
    }

    @Test
    fun buildKitchen_validSelectedPlan_returnKitchenType() {
        assert(KitchenFactory.buildKitchen(1) is PeninsulaKitchen)
    }
}
