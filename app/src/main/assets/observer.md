<pre>
<code>
interface OrderObserver {
    fun onReceived()
}

class OrderRepository {

    private val observers = ArrayList<OrderObserver>()

    fun subscribe(orderObserver: OrderObserver) {
        observers.add(orderObserver)
    }

    fun unsubscribe(orderObserver: OrderObserver) {
        observers.remove(orderObserver)
    }

    fun notifyObservers() {
        for (observer in observers) {
            observer.onReceived()
        }
    }
}

class Customer : OrderObserver {
    override fun onReceived() {
        println("Customer Received Order")
    }

}

class Store : OrderObserver {
    override fun onReceived() {
        println("Order Delivered Successfully")
    }

}
</code>
</pre>