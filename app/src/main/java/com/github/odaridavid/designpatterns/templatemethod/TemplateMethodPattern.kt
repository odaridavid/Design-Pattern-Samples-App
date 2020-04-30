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
package com.github.odaridavid.designpatterns.templatemethod


abstract class SocialEvent {
    abstract fun getSponsors(): List<String>
    abstract fun getActivities(): List<String>
    fun displayBanners() {
        for (sponsor in getSponsors()) {
            println("$sponsor banner")
        }
        for (activity in getActivities()) {
            println("$activity Available")
        }
    }
}

class TheDevsEvent : SocialEvent() {
    override fun getSponsors(): List<String> {
        return emptyList()
    }

    override fun getActivities(): List<String> {
        return emptyList()
    }
}

class RockClimbersEvent : SocialEvent() {
    override fun getSponsors(): List<String> {
        return mutableListOf("TRC")
    }

    override fun getActivities(): List<String> {
        return emptyList()
    }

}