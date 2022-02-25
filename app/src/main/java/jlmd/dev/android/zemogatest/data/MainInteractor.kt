package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity

interface MainInteractor {
    fun deleteAllPosts()
    fun getPostsAPI()
    fun getPostsDB()
    fun clearPosts()
    fun insertAllPost(post: List<PostEntity>)
}