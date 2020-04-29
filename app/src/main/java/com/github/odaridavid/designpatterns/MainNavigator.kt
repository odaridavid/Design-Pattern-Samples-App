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

import android.view.View


interface MainNavigator {

    fun navigateToAbstractFactoryActivity(view: View)

    fun navigateToFactoryActivity(view: View)

    fun navigateToBuilderActivity(view: View)

    fun navigateToPrototypeActivity(view: View)

    fun navigateToSingletonActivity(view: View)

    fun navigateToBridgeActivity(view: View)

    fun navigateToAdapterActivity(view: View)

    fun navigateToCompositeActivity(view: View)

    fun navigateToDecoratorActivity(view: View)

    fun navigateToFacadeActivity(view: View)

    fun navigateToFlyweightActivity(view: View)

    fun navigateToProxyActivity(view: View)

    fun navigateToObserverActivity(view: View)

    fun navigateToStateActivity(view: View)

    fun navigateToStrategyActivity(view: View)

    fun navigateToVisitorActivity(view: View)

    fun navigateToTemplateActivity(view: View)

    fun navigateToIteratorActivity(view: View)

    fun navigateToMementoActivity(view: View)

    fun navigateToMediatorActivity(view: View)

    fun navigateToChainOfResponsibilityActivity(view: View)

    fun navigateToCommandActivity(view: View)
}