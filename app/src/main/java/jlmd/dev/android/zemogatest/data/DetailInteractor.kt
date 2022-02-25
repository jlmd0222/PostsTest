package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.view.model.Post

interface DetailInteractor {
    fun getCommentsAPI(postId: Int?)
    fun getUserAPI(userId: Int?)
    fun updatePost(post: Post)
    fun deletePost(post: Post)
}