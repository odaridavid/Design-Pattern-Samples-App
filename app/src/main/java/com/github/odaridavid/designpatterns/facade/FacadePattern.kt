/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns.facade


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

