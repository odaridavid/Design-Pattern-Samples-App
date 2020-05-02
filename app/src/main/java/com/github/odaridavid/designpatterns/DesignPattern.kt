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

import androidx.annotation.StringRes


data class DesignPattern(
    val patternId: PatternId,
    @StringRes val name: Int
)

fun generateDesignPatterns(): List<DesignPattern> {
    return listOf(
        DesignPattern(PatternId.ADAPTER, R.string.title_adapter),
        DesignPattern(PatternId.ABSTRACT_FACTORY, R.string.title_abstract_factory),
        DesignPattern(PatternId.BRIDGE, R.string.title_bridge),
        DesignPattern(PatternId.BUILDER, R.string.title_builder),
        DesignPattern(PatternId.CHAIN_OF_RESPONSIBILITY, R.string.title_chain_of_responsibility),
        DesignPattern(PatternId.COMMAND, R.string.title_command),
        DesignPattern(PatternId.COMPOSITE, R.string.title_composite),
        DesignPattern(PatternId.DECORATOR, R.string.title_decorator),
        DesignPattern(PatternId.FACADE, R.string.title_facade),
        DesignPattern(PatternId.FACTORY, R.string.title_factory),
        DesignPattern(PatternId.FLYWEIGHT, R.string.title_flyweight),
        DesignPattern(PatternId.ITERATOR, R.string.title_iterator),
        DesignPattern(PatternId.MEDIATOR, R.string.title_mediator),
        DesignPattern(PatternId.MEMENTO, R.string.title_memento),
        DesignPattern(PatternId.OBSERVER, R.string.title_observer),
        DesignPattern(PatternId.PROTOTYPE, R.string.title_prototype),
        DesignPattern(PatternId.PROXY, R.string.title_proxy),
        DesignPattern(PatternId.SINGLETON, R.string.title_singleton),
        DesignPattern(PatternId.STATE, R.string.title_state),
        DesignPattern(PatternId.STRATEGY, R.string.title_strategy),
        DesignPattern(PatternId.TEMPLATE_METHOD, R.string.title_template),
        DesignPattern(PatternId.VISITOR, R.string.title_visitor)
    )
}

enum class PatternId {
    ABSTRACT_FACTORY,
    ADAPTER,
    BRIDGE,
    BUILDER,
    CHAIN_OF_RESPONSIBILITY,
    COMMAND,
    COMPOSITE,
    DECORATOR,
    FACADE,
    FACTORY,
    FLYWEIGHT,
    ITERATOR,
    MEDIATOR,
    MEMENTO,
    OBSERVER,
    PROTOTYPE,
    PROXY,
    SINGLETON,
    STATE,
    STRATEGY,
    TEMPLATE_METHOD,
    VISITOR
}
