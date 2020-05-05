<pre>
<code>
<span class="keyword">interface</span> Bar {
    <span class="keyword">fun</span> setup()
}

<span class="keyword">class</span> CollegeBar : Bar {
    <span class="keyword">override fun</span> setup() {
        <span class="stdlib">println</span>(<span class="string">"College Bar Setup"</span>)
    }
}

<span class="keyword">class</span> SportsBar : Bar {
    <span class="keyword">override fun</span> setup() {
        <span class="stdlib">println</span>(<span class="string">"Sports Bar Setup"</span>)
    }
}

<span class="keyword">abstract class</span> BarDecorator(bar: <span class="types">Bar</span>) : Bar <span class="keyword">by</span> bar

<span class="keyword">class</span> HalloweenBarDecorator(bar: <span class="types">Bar</span>) : BarDecorator(bar) {
    <span class="keyword">override fun</span> setup() {
        <span class="keyword">super</span>.setup()
        <span class="keyword">println</span>(<span class="string">"Adding Halloween Ornaments"</span>)
    }
}

<span class="keyword">class</span> ChristmasBarDecorator(bar: <span class="types">Bar</span>) : BarDecorator(bar) {
    <span class="keyword">override fun</span> setup() {
        <span class="keyword">super</span>.setup()
        <span class="stdlib">println</span>(<span class="string">"Adding Christmas Ornaments"</span>)
    }
}

<span class="keyword">fun</span> main() {
    <span class="keyword">val</span> sportsBar = SportsBar()
    <span class="keyword">val</span> collegeBar = CollegeBar()

    HalloweenBarDecorator(sportsBar).setup()
    ChristmasBarDecorator(collegeBar).setup()
}
</code>
</pre>