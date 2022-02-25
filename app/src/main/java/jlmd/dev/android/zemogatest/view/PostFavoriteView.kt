package jlmd.dev.android.zemogatest.view

import jlmd.dev.android.zemogatest.view.model.Post

interface PostFavoriteView {
    //Va al Presenter -> FavoritePresenter
    fun getFavoritePosts()

    //Va a la View -> FavoritesPostFragment
    fun showFavoritePosts(posts: List<Post>?)
}