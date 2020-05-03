<pre>
<code>
/Object provides singleton out of the box
object CentralBank {
    fun getInstance(): CentralBank = this //Unnecessary
}

class SomeProvider private constructor(name: String) {

    companion object {
        @Volatile
        private var instance: SomeProvider? = null

        fun getInstance(name: String): SomeProvider? {
            return synchronized(this) {
                if (instance != null)
                    instance
                else {
                    instance = SomeProvider(name)
                    instance
                }
            }
        }
    }
}
</code>
</pre>