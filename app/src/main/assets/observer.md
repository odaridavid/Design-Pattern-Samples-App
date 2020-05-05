<pre>
<code>
<span class="keyword">interface</span> NewsletterSubscription {
    <span class="keyword">fun</span> onNewsletterPublished()
}

<span class="keyword">class</span> NewsletterPublisher {

    <span class="keyword">private val</span> observers = <span class="stdlib">ArrayList</span><<span class="types">NewsletterSubscription</span>>()

    <span class="keyword">fun</span> subscribe(newsletterSubscription: <span class="types">NewsletterSubscription</span>) {
        observers.add(newsletterSubscription)
    }

    <span class="keyword">fun</span> unsubscribe(newsletterSubscription: <span class="types">NewsletterSubscription</span>) {
        observers.remove(newsletterSubscription)
    }

    <span class="keyword">fun</span> notifySubscribedReaders() {
        observers.<span class="stdlib">forEach</span> <span class="stdlib">{</span> observer ->
            observer.onNewsletterPublished()
        <span class="stdlib">}</span>
    }
}

<span class="keyword">class</span> Reader : NewsletterSubscription {
    <span class="keyword">override fun</span> onNewsletterPublished() {
        <span class="stdlib">println</span>(<span class="string">"Hey!! Check out our latest newsletter."</span>)
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> newsletterPublisher = NewsletterPublisher()
    <span class="keyword">val</span> reader1 = Reader()
    <span class="keyword">val</span> reader2 = Reader()

    newsletterPublisher.subscribe(reader1)
    newsletterPublisher.subscribe(reader2)

    newsletterPublisher.notifySubscribedReaders()
}
</code>
</pre>