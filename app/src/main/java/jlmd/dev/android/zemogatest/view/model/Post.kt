package jlmd.dev.android.zemogatest.view.model

import jlmd.dev.android.zemogatest.data.database.entities.PostEntity
import jlmd.dev.android.zemogatest.data.model.PostModel
import java.io.Serializable

data class Post(var id: Int,
                var userId: Int,
                var title: String,
                var body: String,
                var isFavorite: Boolean = false) : Serializable


fun PostEntity.toUI() = Post(id, userId, title, body, isFavorite)
fun PostModel.toUI() = Post(id, userId, title, body, isFavorite)