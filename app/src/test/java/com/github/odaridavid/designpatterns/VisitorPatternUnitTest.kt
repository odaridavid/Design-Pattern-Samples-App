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

import com.github.odaridavid.designpatterns.visitor.AccomodationVisitor
import com.github.odaridavid.designpatterns.visitor.AirBnb
import com.github.odaridavid.designpatterns.visitor.Hotel
import com.github.odaridavid.designpatterns.visitor.Lodging
import org.junit.Test


class VisitorPatternUnitTest {

    @Test
    fun accomodation_VisitorPattern() {
        val accVisitor = AccomodationVisitor()
        val hotel = Hotel(4)
        val lodging = Lodging(9)
        val airBnb = AirBnb(5)

        airBnb.accept(accVisitor)
        hotel.accept(accVisitor)
        lodging.accept(accVisitor)
    }

}
