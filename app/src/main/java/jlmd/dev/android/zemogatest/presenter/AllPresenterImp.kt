package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.data.PostInteractor
import jlmd.dev.android.zemogatest.data.PostInteractorImp
import jlmd.dev.android.zemogatest.view.PostView
import jlmd.dev.android.zemogatest.view.model.Post

class AllPresenterImp(var postView: PostView): AllPresenter {

    private var postInteractor: PostInteractor = PostInteractorImp(this)

    override fun getPosts() {
        postInteractor.getPostsDB()
    }

    override fun showPosts(posts: List<Post>?, type: Int) {
        postView.showPosts(posts)
    }
}