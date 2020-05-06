<pre>
<code>
<span class="keyword">abstract class</span> Window {
    <span class="keyword">abstract fun</span> getWidth(): <span class="types">Float</span>
    <span class="keyword">abstract fun</span> getHeight(): <span class="types">Float</span>
    <span class="keyword">abstract fun</span> render(height: <span class="types">Float</span>, width: <span class="types">Float</span>)
    <span class="keyword">fun</span> draw() {
        render(getHeight(), getWidth())
    }
}

<span class="keyword">class</span> RectangularWindow : Window() {
    <span class="keyword">override fun</span> getWidth(): <span class="types">Float</span> = <span class="literals">1024.0f</span>

    <span class="keyword">override fun</span> getHeight(): <span class="types">Float</span> = <span class="literals">512.0f</span>

    <span class="keyword">override fun</span> render(height: <span class="types">Float</span>, width: <span class="types">Float)</span> {
        <span class="stdlib">println</span>(<span class="string">"Rendering window of $height pixels by $width pixels"</span>)
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> rectangularWindow = RectangularWindow()
    rectangularWindow.draw()
}
</code>
</pre>