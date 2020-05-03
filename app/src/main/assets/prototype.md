<pre>
<code>
data class Configs(private val fallbackUri: String, private val defaultPort: Int) {
    override fun toString(): String {
        return "$fallbackUri/$defaultPort"
    }
}

</code>
</pre>