package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity


interface PostRepository {
    fun getPostsFromDB()
    fun getPostsAPI()
    fun insertAllPost(post: List<PostEntity>)
    fun clearPosts()
}