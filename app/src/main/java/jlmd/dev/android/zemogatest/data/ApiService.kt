package jlmd.dev.android.zemogatest.data

import jlmd.dev.android.zemogatest.data.model.Comment
import jlmd.dev.android.zemogatest.data.model.PostModel
import jlmd.dev.android.zemogatest.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("posts/")
    fun getPosts(): Call<List<PostModel>>

    @GET("comments")
    fun getComments(@Query("postId") postId: Int?): Call<List<Comment>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int?): Call<User>
}