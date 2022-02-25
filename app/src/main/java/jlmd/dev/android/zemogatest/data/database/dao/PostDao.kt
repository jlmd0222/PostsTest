package jlmd.dev.android.zemogatest.data.database.dao

import androidx.room.*
import jlmd.dev.android.zemogatest.data.database.entities.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM post_table ORDER BY isFavorite DESC")
    fun getAllPosts() : List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPosts(posts: List<PostEntity>)

    @Update
    fun updatePost(post: PostEntity)

    @Delete
    fun deletePost(post: PostEntity)

    @Query("DELETE FROM post_table")
    fun deleteAllPosts()

    @Query("SELECT * FROM post_table WHERE isFavorite = 1")
    fun getFavoritePosts() : List<PostEntity>
}