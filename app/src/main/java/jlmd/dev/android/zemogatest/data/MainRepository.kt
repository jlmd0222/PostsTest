package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity

interface MainRepository {
    fun deleteAllPosts()
    fun getPostsAPI()
    fun getPostsDB()
    fun clearPosts()
    fun insertAllPost(post: List<PostEntity>)
}