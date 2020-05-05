<pre>
<code>
<span class="keyword">interface</span> BillingStrategy {
    <span class="keyword">fun</span> pay(): <span class="types">String</span>
}

<span class="keyword">class</span> Mpesa : BillingStrategy {
    <span class="keyword">override fun</span> pay(): <span class="types">String</span> = <span class="string">"Pay through M-pesa"</span>
}

<span class="keyword">class</span> CashOnDelivery : BillingStrategy {
    <span class="keyword">override fun</span> pay(): <span class="keyword">String</span> = <span class="string">"Pay cash on delivery"</span>
}

<span class="keyword">class</span> OrderTransaction(<span class="keyword">val</span> transactionProcess: (<span class="types">BillingStrategy</span>) -> <span class="types">String</span>) {

    <span class="keyword">var</span> billingStrategy: <span class="types">BillingStrategy?</span> = <span class="keyword">null</span>

    <span class="keyword">fun</span> finalizeTransaction(): <span class="types">String</span> {
        <span class="keyword">return</span> billingStrategy?<span class="stdlib">.run</span> <span class="stdlib">{</span> transactionProcess(<span class="keyword">this</span>) <span class="stdlib">}</span> ?: <span class="string">"No Billing Method Selected"</span>
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> order = OrderTransaction <span class="stdlib">{</span> billingStrategy -> billingStrategy.pay() <span class="stdlib">}</span>
    <span class="assertions">assert</span>(order.finalizeTransaction()<span class="stdlib">.contains</span>(<span class="string">"No Billing Method Selected"</span>))

    order.billingStrategy = Mpesa()
    <span class="assertions">assert</span>(order.finalizeTransaction()<span class="stdlib">.contains</span>(<span class="string">"Pay through M-pesa"</span>))

    order.billingStrategy = CashOnDelivery()
    <span class="assertions">assert</span>(order.finalizeTransaction()<span class="stdlib">.contains</span>(<span class="string">"Pay cash on delivery"</span>))
}
</code>
</pre>