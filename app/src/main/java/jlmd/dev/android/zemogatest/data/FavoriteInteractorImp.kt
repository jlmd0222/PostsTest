package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.presenter.FavoritePresenter

class FavoriteInteractorImp(var favoritePresenter: FavoritePresenter): FavoriteInteractor {

    private var favoriteRepository: FavoriteRepository = FavoriteRepositoryImp(favoritePresenter)

    override fun getFavoritePosts() {
        favoriteRepository.getFavoritePost()
    }
}