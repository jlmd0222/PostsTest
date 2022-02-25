package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.view.model.Post

interface AllPresenter {
    //Va a la View
    //receive list
    fun showPosts(posts: List<Post>?, type: Int)

    //Va al Interactor
    fun getPosts()
}