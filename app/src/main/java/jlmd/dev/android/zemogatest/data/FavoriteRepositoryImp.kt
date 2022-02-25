package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.PostApplication
import jlmd.dev.android.zemogatest.presenter.FavoritePresenter
import jlmd.dev.android.zemogatest.view.model.toUI
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavoriteRepositoryImp(var favoritePresenter: FavoritePresenter): FavoriteRepository {

    override fun getFavoritePost() {
        doAsync {
            val postsDB = PostApplication.dataBase?.getPostDao()?.getFavoritePosts()
            uiThread {
                val postUI = postsDB?.map { it.toUI() }
                favoritePresenter.showFavoritePosts(postUI)
            }
        }
    }
}