<pre>
<code>
<span class="keyword">class</span> User(<span class="keyword">val</span> parcelId: <span class="types">Int</span>, <span class="keyword">val</span> name: <span class="types">String</span>) {
    <span class="keyword">fun</span> parcelStatus(status: <span class="types">String</span>) {
        <span class="stdlib">println</span>(<span class="string">"Update for <span class="string-template">$name</span> :: Parcel Status : <span class="string-template">$status</span>"</span>)
    }
}

<span class="keyword">class</span> Parcel(<span class="keyword">private val</span> id: <span class="types">Int</span>, <span class="keyword">var</span> status: <span class="types">String</span>, <span class="keyword">private val</span> mediator: <span class="types">ParcelMediator</span>) {
    <span class="keyword">fun</span> sendParcel() {
        mediator.updateParcelStatus(id, status)
    }
}

<span class="keyword">class</span> ParcelMediator {
    <span class="keyword">private val</span> observers = <span class="keyword">ArrayList</span><<span class="types">User</span>>()

    <span class="keyword">fun</span> receivers(user: <span class="types">User</span>) {
        observers.add(user)
    }

    <span class="keyword">fun</span> updateParcelStatus(id: <span class="types">Int</span>, status: <span class="types">String</span>) {
        observers.<span class="stdlib">forEach</span> { user ->
            <span class="keyword">if</span> (user.parcelId == id) {
                user.parcelStatus(status)
            }
        }
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> john = User(<span class="arguments">name</span> = <span class="string">"John"</span>, <span class="arguments">parcelId</span> = <span class="literals">1</span>)
    <span class="keyword">val</span> mary = User(<span class="arguments">name</span> = <span class="string">"Mary"</span>, <span class="arguments">parcelId</span> = <span class="literals">1</span>)
    <span class="keyword">val</span> don = User(<span class="arguments">name</span> = <span class="string">"Don"</span>, <span class="arguments">parcelId</span> = <span class="literals">2</span>)

    <span class="keyword">val</span> parcelMediator = ParcelMediator()
    <span class="keyword">val</span> parcel = Parcel(<span class="arguments">id</span>=1, <span class="arguments">status</span>=<span class="string">"En-Route"</span>, <span class="arguments">mediator</span>=parcelMediator)

    parcelMediator.receivers(john)
    parcelMediator.receivers(mary)
    <span class="comments">//Won't Receive</span>
    parcelMediator.receivers(don)

    parcel.sendParcel()
}
</code>
</pre>