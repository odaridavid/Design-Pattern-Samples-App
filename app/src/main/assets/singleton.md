<pre>
<code>
<span class="comment">//Object provides singleton out of the box</span>
<span class="keyword">object</span> CentralBank {
    <span class="keyword">fun</span> getMoney() = <span class="string">"$10 Billion"</span>
}

<span class="keyword">fun</span> main() {
    <span class="assertions">assert</span>(CentralBank.getMoney() === CentralBank.getMoney())
}
</code>
</pre>