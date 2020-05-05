<pre>
<code>
<span class="keyword">interface</span> Animator {
    <span class="keyword">fun</span> animate()
}

<span class="keyword">interface</span> Interpolator {
    <span class="keyword">fun</span> interpolate()
}

<span class="keyword">class</span> SwingAnimator : Animator {
    <span class="keyword">override fun</span> animate() {
        <span class="stdlib">println</span>(<span class="string">"Doing Swing Animation"</span>)
    }
}

<span class="keyword">class</span> LinearInterpolator : Interpolator {
    <span class="keyword">override fun</span> interpolate() {
        <span class="stdlib">println</span>(<span class="string">"Applying Interpolator to animation"</span>)
    }
}

<span class="comments">//Facade</span>
<span class="keyword">class</span> AnimationDirector {
    <span class="keyword">private val</span> interpolator: <span class="types">Interpolator</span> = LinearInterpolator()
    <span class="keyword">private val</span> animator: <span class="types">Animator</span> = SwingAnimator()

    <span class="keyword">fun</span> performAnimations() {
        interpolator.interpolate()
        animator.animate()
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> animationDirector = AnimationDirector()
    animationDirector.performAnimations()
}
</code>
</pre>