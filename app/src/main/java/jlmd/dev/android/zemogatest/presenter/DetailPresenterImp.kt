package jlmd.dev.android.zemogatest.presenter

import jlmd.dev.android.zemogatest.data.model.Comment
import jlmd.dev.android.zemogatest.data.DetailInteractor
import jlmd.dev.android.zemogatest.data.DetailInteractorImp
import jlmd.dev.android.zemogatest.data.model.User
import jlmd.dev.android.zemogatest.view.PostDetailView
import jlmd.dev.android.zemogatest.view.model.Post


class DetailPresenterImp(var detailView: PostDetailView): DetailPresenter {
    private var detailInteractor: DetailInteractor = DetailInteractorImp(this)

    override fun showComments(comments: List<Comment>?) {
        detailView.showComments(comments)
    }

    override fun getComments(postId: Int?) {
        detailInteractor.getCommentsAPI(postId)
    }

    override fun getUser(userId: Int?) {
        detailInteractor.getUserAPI(userId)
    }

    override fun showUser(user: User?) {
        detailView.showUser(user)
    }

    override fun updatePost(post: Post) {
        detailInteractor.updatePost(post)
    }

    override fun deletePost(post: Post) {
        detailInteractor.deletePost(post)
    }

    override fun updateView() {
        detailView.updateView()
    }
}