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
package com.github.odaridavid.designpatterns.models

import android.os.Parcelable
import androidx.annotation.StringRes
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.helpers.CodeSample
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class DesignPattern(
    @StringRes val name: Int,
    @StringRes val description: Int,
    val codeSample: String
) : Parcelable

internal fun generateDesignPatterns(): List<DesignPattern> {
    return listOf(
        DesignPattern(
            R.string.title_adapter,
            R.string.desc_adapter,
            CodeSample.ADAPTER
        ),
        DesignPattern(
            R.string.title_abstract_factory,
            R.string.desc_abstract_factory,
            CodeSample.ABSTRACT_FACTORY
        ),
        DesignPattern(
            R.string.title_bridge,
            R.string.desc_bridge,
            CodeSample.BRIDGE
        ),
        DesignPattern(
            R.string.title_builder,
            R.string.desc_builder,
            CodeSample.BUILDER
        ),
        DesignPattern(
            R.string.title_chain_of_responsibility,
            R.string.desc_chain_of_responsibility,
            CodeSample.CHAIN_OF_RESPONSIBILITY
        ),
        DesignPattern(
            R.string.title_command,
            R.string.desc_command,
            CodeSample.COMMAND
        ),
        DesignPattern(
            R.string.title_composite,
            R.string.desc_composite,
            CodeSample.COMPOSITE
        ),
        DesignPattern(
            R.string.title_decorator,
            R.string.desc_decorator,
            CodeSample.DECORATOR
        ),
        DesignPattern(
            R.string.title_facade,
            R.string.desc_facade,
            CodeSample.FACADE
        ),
        DesignPattern(
            R.string.title_factory,
            R.string.desc_factory,
            CodeSample.FACTORY
        ),
        DesignPattern(
            R.string.title_flyweight,
            R.string.desc_flyweight,
            CodeSample.FLYWEIGHT
        ),
        DesignPattern(
            R.string.title_iterator,
            R.string.desc_iterator,
            CodeSample.ITERATOR
        ),
        DesignPattern(
            R.string.title_mediator,
            R.string.desc_mediator,
            CodeSample.MEDIATOR
        ),
        DesignPattern(
            R.string.title_memento,
            R.string.desc_memento,
            CodeSample.MEMENTO
        ),
        DesignPattern(
            R.string.title_observer,
            R.string.desc_observer,
            CodeSample.OBSERVER
        ),
        DesignPattern(
            R.string.title_prototype,
            R.string.desc_prototype,
            CodeSample.PROTOTYPE
        ),
        DesignPattern(
            R.string.title_proxy,
            R.string.desc_proxy,
            CodeSample.PROXY
        ),
        DesignPattern(
            R.string.title_singleton,
            R.string.desc_singleton,
            CodeSample.SINGLETON
        ),
        DesignPattern(
            R.string.title_state,
            R.string.desc_state,
            CodeSample.STATE
        ),
        DesignPattern(
            R.string.title_strategy,
            R.string.desc_strategy,
            CodeSample.STRATEGY
        ),
        DesignPattern(
            R.string.title_template,
            R.string.desc_template_method,
            CodeSample.TEMPLATE_METHOD
        ),
        DesignPattern(
            R.string.title_visitor,
            R.string.desc_visitor,
            CodeSample.VISITOR
        )
    )
}

