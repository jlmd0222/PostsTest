package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity

interface DetailRepository {
    fun getCommentsAPI(postId: Int?)
    fun getUserAPI(userId: Int?)
    fun updatePost(post: PostEntity)
    fun deletePost(post: PostEntity)
}