package jlmd.dev.android.zemogatest.view

import jlmd.dev.android.zemogatest.data.model.Comment
import jlmd.dev.android.zemogatest.data.model.User
import jlmd.dev.android.zemogatest.view.model.Post

interface PostDetailView {
    //Va al Presenter -> DetailPresenter
    fun getComments()
    fun getUser()
    fun setFavoritePost(post: Post)
    fun deletePost(post: Post)
    fun updateView()

    //Va a la View -> PostDetailActivity
    fun showComments(comments: List<Comment>?)
    fun showUser(user: User?)
}