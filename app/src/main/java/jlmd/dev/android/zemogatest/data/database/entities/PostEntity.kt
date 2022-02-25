package jlmd.dev.android.zemogatest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import jlmd.dev.android.zemogatest.view.model.Post

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "userId") var userId: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "body") var body: String,
    @ColumnInfo(name = "isFavorite") var isFavorite: Boolean = false)

fun Post.toDataBase() = PostEntity(id, userId, title, body, isFavorite)