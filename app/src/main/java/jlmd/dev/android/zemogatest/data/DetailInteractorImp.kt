package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.toDataBase
import jlmd.dev.android.zemogatest.presenter.DetailPresenter
import jlmd.dev.android.zemogatest.view.model.Post

class DetailInteractorImp(var detailPresenter: DetailPresenter): DetailInteractor {

    private var detailRepository: DetailRepository = DetailRepositoryImp(detailPresenter)

    override fun getCommentsAPI(postId: Int?) {
        detailRepository.getCommentsAPI(postId)
    }

    override fun getUserAPI(userId: Int?) {
        detailRepository.getUserAPI(userId)
    }

    override fun updatePost(post: Post) {
        val postEntity = post.toDataBase()
        detailRepository.updatePost(postEntity)
    }

    override fun deletePost(post: Post) {
        val postEntity = post.toDataBase()
        detailRepository.deletePost(postEntity)
    }
}