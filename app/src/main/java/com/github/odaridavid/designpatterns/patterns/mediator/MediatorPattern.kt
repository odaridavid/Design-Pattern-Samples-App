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
package com.github.odaridavid.designpatterns.patterns.mediator

class User(val parcelId: Int, val name: String) {
    fun parcelStatus(status: String) {
        println("Update for $name :: Parcel Status : $status")
    }
}

class Parcel(private val id: Int, var status: String, private val mediator: ParcelMediator) {
    fun sendParcel() {
        mediator.updateParcelStatus(id, status)
    }
}

class ParcelMediator {
    private val observers = ArrayList<User>()

    fun receivers(user: User) {
        observers.add(user)
    }

    fun updateParcelStatus(id: Int, status: String) {
        observers.forEach { user ->
            if (user.parcelId == id) {
                user.parcelStatus(status)
            }
        }
    }
}