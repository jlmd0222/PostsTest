package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity
import jlmd.dev.android.zemogatest.presenter.MainPresenter

class MainInteractorImp(var mainPresenter: MainPresenter): MainInteractor {

    private var mainRepository: MainRepository = MainRepositoryImp(mainPresenter)

    override fun deleteAllPosts() {
        mainRepository.deleteAllPosts()
    }

    override fun getPostsAPI() {
        mainRepository.getPostsAPI()
    }

    override fun getPostsDB() {
        mainRepository.getPostsDB()
    }

    override fun clearPosts() {
        mainRepository.clearPosts()
    }

    override fun insertAllPost(post: List<PostEntity>) {
        mainRepository.insertAllPost(post)
    }
}