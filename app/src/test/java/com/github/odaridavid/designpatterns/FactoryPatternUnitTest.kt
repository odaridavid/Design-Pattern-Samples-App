package com.github.odaridavid.designpatterns

import com.github.odaridavid.designpatterns.factory.*
import org.junit.Test

class FactoryPatternUnitTest {

    @Test
    fun getCurrency_validCountry_returnsCurrency() {
        assert(CurrencyFactory.getCurrency(Kenya).code == "KSH")
    }

    @Test
    fun getFloorPlan_validKitchenType_returnFloorPlan() {
        assert(KitchenFloorFactory.getFloorPlan<PeninsulaKitchen>() == FloorPlan.DETACHED)
        assert(KitchenFloorFactory.getFloorPlan<LShapedKitchen>() == FloorPlan.SPACED)
        assert(KitchenFloorFactory.getFloorPlan<IslandKitchen>() == FloorPlan.EXTENDING)
    }
}
