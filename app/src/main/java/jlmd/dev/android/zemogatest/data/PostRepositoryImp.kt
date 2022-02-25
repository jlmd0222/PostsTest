package jlmd.dev.android.zemogatest.data

import android.util.Log
import jlmd.dev.android.zemogatest.data.database.PostApplication
import jlmd.dev.android.zemogatest.data.database.entities.PostEntity
import jlmd.dev.android.zemogatest.data.model.PostModel
import jlmd.dev.android.zemogatest.presenter.AllPresenter
import jlmd.dev.android.zemogatest.view.model.toUI
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepositoryImp(var postPresenter: AllPresenter): PostRepository {

    override fun getPostsFromDB() {
        doAsync {
            val postsDB = PostApplication.dataBase?.getPostDao()?.getAllPosts()
            val postUI = postsDB?.map { it.toUI() }
            uiThread {
                postPresenter.showPosts(postUI, 1)
            }
        }
    }

    override fun getPostsAPI() {
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getPosts()
        call.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
                postPresenter.showPosts(emptyList(), 2)
            }
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                val postsJsonArray = response.body()
                val postUI = postsJsonArray?.map { it.toUI() }
                postPresenter.showPosts(postUI, 2)
            }
        })
    }

    override fun insertAllPost(post: List<PostEntity>) {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.insertAllPosts(post)
            Log.i("INSERT DATA", "OK")
        }
    }

    override fun clearPosts() {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.deleteAllPosts()
        }
    }
}