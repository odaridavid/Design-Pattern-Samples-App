package com.github.odaridavid.designpatterns

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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

class MainActivity : BaseActivity(),
    MainNavigator {

    //TODO Hookup all design patterns to ui and show code examples
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                showDialog("\t\t\t\t\tDesign Patterns", "\n\t\t\t\t\t\t\t\tVersion ${BuildConfig.VERSION_NAME}")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun navigateToAbstractFactoryActivity(view: View) =
        navigateTo<AbstractFactoryActivity>()

    override fun navigateToFactoryActivity(view: View) = navigateTo<FactoryActivity>()

    override fun navigateToBuilderActivity(view: View) = navigateTo<BuilderActivity>()

    override fun navigateToPrototypeActivity(view: View) = navigateTo<PrototypeActivity>()

    override fun navigateToSingletonActivity(view: View) = navigateTo<SingletonActivity>()

    override fun navigateToAdapterActivity(view: View) = navigateTo<AdapterActivity>()

    override fun navigateToBridgeActivity(view: View) = navigateTo<BridgeActivity>()

    override fun navigateToCompositeActivity(view: View) = navigateTo<CompositeActivity>()

    override fun navigateToDecoratorActivity(view: View) = navigateTo<DecoratorActivity>()

    override fun navigateToFacadeActivity(view: View) = navigateTo<FacadeActivity>()

    override fun navigateToFlyweightActivity(view: View) = navigateTo<FlyweightActivity>()

    override fun navigateToProxyActivity(view: View) = navigateTo<ProxyActivity>()

    override fun navigateToChainOfResponsibilityActivity(view: View) =
        navigateTo<ChainOfResponsibilityActivity>()

    override fun navigateToCommandActivity(view: View) = navigateTo<CommandActivity>()

    override fun navigateToVisitorActivity(view: View) = navigateTo<VisitorActivity>()

    override fun navigateToTemplateMethodActivity(view: View) = navigateTo<TemplateMethodActivity>()

    override fun navigateToStrategyActivity(view: View) = navigateTo<StrategyActivity>()

    override fun navigateToStateActivity(view: View) = navigateTo<StateActivity>()

    override fun navigateToObserverActivity(view: View) = navigateTo<ObserverActivity>()

    override fun navigateToMementoActivity(view: View) = navigateTo<MementoActivity>()

    override fun navigateToMediatorActivity(view: View) = navigateTo<MediatorActivity>()

    override fun navigateToIteratorActivity(view: View) = navigateTo<IteratorActivity>()

}
