package jlmd.dev.android.zemogatest.view

import jlmd.dev.android.zemogatest.view.model.Post

interface PostView {
    //Va al Presenter -> AllPresenter
    fun getPosts()

    //Va a la View -> AllPostFragment
    fun showPosts(posts: List<Post>?)
}