package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.data.model.Comment
import jlmd.dev.android.zemogatest.data.model.User
import jlmd.dev.android.zemogatest.view.model.Post

interface DetailPresenter {
    //Va a la View
    fun showComments(comments: List<Comment>?)
    fun showUser(user: User?)

    //Va al Interactor
    fun getComments(postId: Int?)
    fun getUser(userId: Int?)
    fun updatePost(post: Post)
    fun deletePost(post: Post)
    fun updateView()
}