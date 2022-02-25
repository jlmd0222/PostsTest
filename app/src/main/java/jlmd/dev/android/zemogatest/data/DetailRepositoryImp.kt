package jlmd.dev.android.zemogatest.data

import android.util.Log
import jlmd.dev.android.zemogatest.data.database.PostApplication
import jlmd.dev.android.zemogatest.data.database.entities.PostEntity
import jlmd.dev.android.zemogatest.data.model.Comment
import jlmd.dev.android.zemogatest.data.model.User
import jlmd.dev.android.zemogatest.presenter.DetailPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRepositoryImp(var detailPresenter: DetailPresenter) : DetailRepository {

    override fun getCommentsAPI(postId: Int?) {
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getComments(postId)
        call.enqueue(object : Callback<List<Comment>> {
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val commentJsonArray = response.body()
                detailPresenter.showComments(commentJsonArray)
            }
        })
    }

    override fun getUserAPI(userId: Int?) {
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getUser(userId)
        call.enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = response.body()
                detailPresenter.showUser(user)
            }
        })
    }

    override fun updatePost(post: PostEntity) {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.updatePost(post)
        }
    }

    override fun deletePost(post: PostEntity) {
        doAsync {
            PostApplication.dataBase?.getPostDao()?.deletePost(post)
            uiThread {
                detailPresenter.updateView()
            }
        }
    }
}