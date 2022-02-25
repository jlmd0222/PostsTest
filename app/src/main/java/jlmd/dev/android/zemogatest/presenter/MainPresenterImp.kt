package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.data.MainInteractor
import jlmd.dev.android.zemogatest.data.MainInteractorImp
import jlmd.dev.android.zemogatest.data.database.entities.toDataBase
import jlmd.dev.android.zemogatest.view.PostMainView
import jlmd.dev.android.zemogatest.view.model.Post

class MainPresenterImp(var postMainView: PostMainView): MainPresenter {

    private var mainInteractor: MainInteractor = MainInteractorImp(this)

    override fun deleteAllPosts() {
        mainInteractor.deleteAllPosts()
    }

    override fun updateView() {
        postMainView.updateView()
    }

    override fun getPosts() {
        mainInteractor.getPostsDB()
    }

    override fun showPosts(posts: List<Post>?, type: Int) {
        if (posts != null && posts.isNotEmpty()) {
            if(type == 2) {
                mainInteractor.clearPosts()
                mainInteractor.insertAllPost(posts.map { it.toDataBase() })
            }
            postMainView.updateView()
        }else {
            mainInteractor.getPostsAPI()
        }
    }
}