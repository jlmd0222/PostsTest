package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.data.FavoriteInteractor
import jlmd.dev.android.zemogatest.data.FavoriteInteractorImp
import jlmd.dev.android.zemogatest.view.PostFavoriteView
import jlmd.dev.android.zemogatest.view.model.Post

class FavoritePresenterImp(var favoriteView: PostFavoriteView): FavoritePresenter {

    private var favoriteInteractor: FavoriteInteractor = FavoriteInteractorImp(this)

    override fun showFavoritePosts(posts: List<Post>?) {
        if (posts?.isNotEmpty() == true){
            favoriteView.showFavoritePosts(posts)
        }
    }

    override fun getFavoritePosts() {
        favoriteInteractor.getFavoritePosts()
    }
}