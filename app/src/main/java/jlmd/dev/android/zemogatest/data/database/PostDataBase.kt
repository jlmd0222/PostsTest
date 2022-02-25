package jlmd.dev.android.zemogatest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import jlmd.dev.android.zemogatest.data.database.dao.PostDao
import jlmd.dev.android.zemogatest.data.database.entities.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class PostDataBase: RoomDatabase() {
    //for every dao there must be a function
    abstract fun getPostDao(): PostDao
}