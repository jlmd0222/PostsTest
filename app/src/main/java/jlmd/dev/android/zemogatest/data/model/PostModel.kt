package jlmd.dev.android.zemogatest.data.model

import java.io.Serializable

data class PostModel(var id: Int,
                var userId: Int,
                var title: String,
                var body: String,
                var isFavorite: Boolean = false): Serializable