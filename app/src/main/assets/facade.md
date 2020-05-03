<pre>
<code>
class User(val id: Long, val name: String, val followers: Int, val following: Int)
class Post(val id: Long, val content: String, val comments: List<Comment>)
class Comment(val content: String, val userId: Long, val postId: Long)

class UsersApi {
    fun getUsers(): List<User> {
        return mutableListOf(User(909, "David", 38, 289))
    }
}

class PostsApi {
    fun loadPosts(userId: Long): List<Post> {
        return mutableListOf(Post(9898, "", emptyList()))
    }
}

class CommentsApi {
    fun loadComments(postId: Long): Comment {
        return Comment("", 9898, postId)
    }
}

class TimeLineFacade {
    private val commentsApi = CommentsApi()
    private val postsApi = PostsApi()
    private val usersApi = UsersApi()
    fun loadTimeLine() {
        for (users in usersApi.getUsers()) {
            val posts = postsApi.loadPosts(users.id)
            for (post in posts) {
                val comments = commentsApi.loadComments(post.id)
            }
            //Etc...
        }
    }
}

</code>
</pre>