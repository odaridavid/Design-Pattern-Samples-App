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

import android.app.Activity
import com.github.odaridavid.designpatterns.abstractfactory.AbstractFactoryActivity
import com.github.odaridavid.designpatterns.adapter.AdapterActivity
import com.github.odaridavid.designpatterns.bridge.BridgeActivity
import com.github.odaridavid.designpatterns.builder.BuilderActivity
import com.github.odaridavid.designpatterns.chainofresponsibility.ChainOfResponsibilityActivity
import com.github.odaridavid.designpatterns.command.CommandActivity
import com.github.odaridavid.designpatterns.composite.CompositeActivity
import com.github.odaridavid.designpatterns.decorator.DecoratorActivity
import com.github.odaridavid.designpatterns.facade.FacadeActivity
import com.github.odaridavid.designpatterns.factory.FactoryActivity
import com.github.odaridavid.designpatterns.flyweight.FlyweightActivity
import com.github.odaridavid.designpatterns.iterator.IteratorActivity
import com.github.odaridavid.designpatterns.mediator.MediatorActivity
import com.github.odaridavid.designpatterns.memento.MementoActivity
import com.github.odaridavid.designpatterns.observer.ObserverActivity
import com.github.odaridavid.designpatterns.prototype.PrototypeActivity
import com.github.odaridavid.designpatterns.proxy.ProxyActivity
import com.github.odaridavid.designpatterns.singleton.SingletonActivity
import com.github.odaridavid.designpatterns.state.StateActivity
import com.github.odaridavid.designpatterns.strategy.StrategyActivity
import com.github.odaridavid.designpatterns.templatemethod.TemplateMethodActivity
import com.github.odaridavid.designpatterns.visitor.VisitorActivity


class NavigationController(private val activity: Activity) {

    fun navigateTo(patternId: PatternId) {
        when (patternId) {
            PatternId.ABSTRACT_FACTORY -> activity.navigateTo<AbstractFactoryActivity>()
            PatternId.ADAPTER -> activity.navigateTo<AdapterActivity>()
            PatternId.BRIDGE -> activity.navigateTo<BridgeActivity>()
            PatternId.BUILDER -> activity.navigateTo<BuilderActivity>()
            PatternId.CHAIN_OF_RESPONSIBILITY -> activity.navigateTo<ChainOfResponsibilityActivity>()
            PatternId.COMMAND -> activity.navigateTo<CommandActivity>()
            PatternId.COMPOSITE -> activity.navigateTo<CompositeActivity>()
            PatternId.DECORATOR -> activity.navigateTo<DecoratorActivity>()
            PatternId.FACADE -> activity.navigateTo<FacadeActivity>()
            PatternId.FACTORY -> activity.navigateTo<FactoryActivity>()
            PatternId.FLYWEIGHT -> activity.navigateTo<FlyweightActivity>()
            PatternId.ITERATOR -> activity.navigateTo<IteratorActivity>()
            PatternId.MEDIATOR -> activity.navigateTo<MediatorActivity>()
            PatternId.MEMENTO -> activity.navigateTo<MementoActivity>()
            PatternId.OBSERVER -> activity.navigateTo<ObserverActivity>()
            PatternId.PROTOTYPE -> activity.navigateTo<PrototypeActivity>()
            PatternId.PROXY -> activity.navigateTo<ProxyActivity>()
            PatternId.SINGLETON -> activity.navigateTo<SingletonActivity>()
            PatternId.STATE -> activity.navigateTo<StateActivity>()
            PatternId.STRATEGY -> activity.navigateTo<StrategyActivity>()
            PatternId.TEMPLATE_METHOD -> activity.navigateTo<TemplateMethodActivity>()
            PatternId.VISITOR -> activity.navigateTo<VisitorActivity>()
        }
    }
}