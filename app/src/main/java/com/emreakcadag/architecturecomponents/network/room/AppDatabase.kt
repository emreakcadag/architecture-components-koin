package com.emreakcadag.architecturecomponents.network.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emreakcadag.architecturecomponents.feature.main.data.repository.local.MainResponseDao
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
@Database(entities = [MainResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mainResponseDao(): MainResponseDao

    companion object {
        private const val DB_NAME = "app_database"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}