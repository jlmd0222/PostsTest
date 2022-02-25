package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.view.model.Post

interface MainPresenter {
    fun deleteAllPosts()
    fun updateView()
    fun getPosts()
    fun showPosts(posts: List<Post>?, type: Int)
}