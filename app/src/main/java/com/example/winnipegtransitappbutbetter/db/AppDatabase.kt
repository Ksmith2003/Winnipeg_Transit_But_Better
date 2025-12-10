package com.example.winnipegtransitappbutbetter.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop

@Database(entities = [Route::class, Stop::class], version=2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun WTDao(): WTDao

    companion object{
        // use the companion object
        // to implement the Singleton Pattern. Oh My!
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance  = Room.databaseBuilder(
                    context = context.applicationContext,
                    AppDatabase::class.java,
                    "MovieHub FALL 2025"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}