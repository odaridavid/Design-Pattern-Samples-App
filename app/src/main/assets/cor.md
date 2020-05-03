<pre>
<code>
interface Processing {
    var process: String
    fun processProduct(next: Processing): Processing
}

abstract class BaseProcessing(override var process: String, var next: Processing? = null) :
    Processing {

    override fun processProduct(next: Processing): Processing {
        this.next = next
        println("From $process")
        println("To ${next.process}")
        return this
    }

}

class ConvertRawMaterial : BaseProcessing("Convert Raw Material")

class Packaging : BaseProcessing("Packaging")

class Labeling : BaseProcessing("Labeling")

</code>
</pre>