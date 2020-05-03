<pre>
<code>
class User(val parcelId: Int, val name: String) {
    fun parcelStatus(status: String) {
        println("Update for $name :: Parcel Status : $status")
    }
}

class Parcel(private val id: Int, var status: String, private val parcelMediator: ParcelMediator) {

    fun sendParcel() {
        parcelMediator.updateParcelStatus(id, status)
    }

}

class ParcelMediator {
    private val observers = ArrayList<User>()

    fun receivers(user: User) {
        observers.add(user)
    }

    fun updateParcelStatus(id: Int, status: String) {
        observers.forEach { user ->
            if (user.parcelId == id) {
                user.parcelStatus(status)
            }
        }
    }
}
</code>
</pre>