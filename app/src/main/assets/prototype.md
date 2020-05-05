<pre>
<code>
<span class="keyword">data class</span> Configs(<span class="keyword">val</span> fallbackUri: <span class="types">String</span>, <span class="keyword">val</span> defaultPort: <span class="types">Int</span>) {
    <span class="keyword">override fun</span> toString(): <span class="types">String</span> {
        <span class="keyword">return</span> <span class="string">"<span class="string-template">$fallbackUri/$defaultPort</span>"</span>
    }
}

<span class="comments">//Note: copy() performs a shallow copy</span>
<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> conf = Configs(<span class="string">"https://www.google.com"</span>, <span class="literals">8080</span>)
    <span class="keyword">val</span> confCopy = conf<span class="stdlib">.copy</span>(<span class="arguments">fallbackUri</span> = <span class="literals">"https://www.fallback.com"</span>)
    <span class="assertions">assert</span>(conf.defaultPort == confCopy.defaultPort)
}
</code>
</pre>