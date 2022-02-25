package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity
import jlmd.dev.android.zemogatest.presenter.AllPresenter

class PostInteractorImp(var postPresenter: AllPresenter): PostInteractor {

    private var postRepository: PostRepository = PostRepositoryImp(postPresenter)

    override fun getPostsDB() {
        postRepository.getPostsFromDB()
    }

    override fun getPostsAPI() {
        postRepository.getPostsAPI()
    }

    override fun clearPosts() {
        postRepository.clearPosts()
    }

    override fun insertAllPost(post: List<PostEntity>) {
        postRepository.insertAllPost(post)
    }
}