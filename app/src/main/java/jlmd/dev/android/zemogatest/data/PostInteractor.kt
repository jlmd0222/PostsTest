package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity


interface PostInteractor {
    fun getPostsDB()
    fun getPostsAPI()
    fun clearPosts()
    fun insertAllPost(post: List<PostEntity>)
}