package jlmd.dev.android.zemogatest.data.database

import android.app.Application
import android.content.Context
import androidx.room.Room

class PostApplication : Application() {
    companion object {
        var dataBase: PostDataBase? = null
        const val POST_DATABASE_NAME = "post_database"
    }

    override fun onCreate() {
        super.onCreate()

        dataBase = Room.databaseBuilder(this,
            PostDataBase::class.java,
            POST_DATABASE_NAME).allowMainThreadQueries().build()
    }
}