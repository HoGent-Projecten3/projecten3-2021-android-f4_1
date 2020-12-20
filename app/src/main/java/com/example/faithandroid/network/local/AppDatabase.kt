package com.example.faithandroid.network.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.faithandroid.models.Avatar
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Playlist
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.Step

// import com.example.faithandroid.models

@Database(entities = [GoalPost::class, Step::class, Playlist::class, Post::class, Avatar::class], version = 5, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun goalPostDao(): GoalPostDao
    abstract fun spotifyDao(): SpotifyDao
    abstract fun postDao(): PostDao
    abstract fun avatarDao(): AvatarDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "GROWDB")
                .fallbackToDestructiveMigration()
                .build()
    }
}
