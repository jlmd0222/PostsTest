package jlmd.dev.android.zemogatest.data

import android.util.Log
import jlmd.dev.android.zemogatest.data.database.PostApplication
import jlmd.dev.android.zemogatest.data.database.entities.PostEntity
import jlmd.dev.android.zemogatest.data.model.PostModel
import jlmd.dev.android.zemogatest.presenter.MainPresenter
import jlmd.dev.android.zemogatest.view.model.toUI
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImp(var mainPresenter: MainPresenter): MainRepository {

    override fun deleteAllPosts() {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.deleteAllPosts()
            uiThread {
                mainPresenter.updateView()
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
                mainPresenter.showPosts(emptyList(), 2)
            }
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                val postsJsonArray = response.body()
                val postUI = postsJsonArray?.map { it.toUI() }
                mainPresenter.showPosts(postUI, 2)
            }
        })
    }

    override fun getPostsDB() {
        doAsync {
            val postsDB = PostApplication.dataBase?.getPostDao()?.getAllPosts()
            val postUI = postsDB?.map { it.toUI() }
            uiThread {
                mainPresenter.showPosts(postUI, 1)
            }
        }
    }

    override fun clearPosts() {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.deleteAllPosts()
        }
    }

    override fun insertAllPost(post: List<PostEntity>) {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.insertAllPosts(post)
            Log.i("INSERT DATA", "OK")
        }
    }
}