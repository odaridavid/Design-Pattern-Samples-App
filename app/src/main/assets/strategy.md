<pre>
<code>
interface BillingStrategy {
    fun pay(): String
}

class Mpesa : BillingStrategy {
    override fun pay(): String = "Pay by M-pesa"
}

class CashOnDelivery : BillingStrategy {
    override fun pay(): String = "Pay on Delivery"
}

class Order {
    private var billingStrategy: BillingStrategy? = null

    fun setStrategy(billingStrategy: BillingStrategy) {
        this.billingStrategy = billingStrategy
    }

    fun submitOrder(): String {
        return billingStrategy?.pay() ?: "No Payment Option Selected"
    }
}

//functional

class MarkdownFormatter(var formatterStrategy: (String) -> String) {
    fun format(string: String) {
        println(formatterStrategy(string))
    }
}
</code>
</pre>