package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.view.model.Post

interface FavoritePresenter {
    //Va a la View
    fun showFavoritePosts(posts: List<Post>?)

    //Va al Interactor
    fun getFavoritePosts()
}