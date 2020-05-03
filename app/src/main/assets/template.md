<pre>
<code>
abstract class SocialEvent {
    abstract fun getSponsors(): List<String>
    abstract fun getActivities(): List<String>
    fun displayBanners() {
        for (sponsor in getSponsors()) {
            println("$sponsor banner")
        }
        for (activity in getActivities()) {
            println("$activity Available")
        }
    }
}

class TheDevsEvent : SocialEvent() {
    override fun getSponsors(): List<String> {
        return emptyList()
    }

    override fun getActivities(): List<String> {
        return emptyList()
    }
}

class RockClimbersEvent : SocialEvent() {
    override fun getSponsors(): List<String> {
        return mutableListOf("TRC")
    }

    override fun getActivities(): List<String> {
        return emptyList()
    }
}
</code>
</pre>