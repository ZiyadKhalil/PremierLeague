package com.example.premierleague.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.premierleague.data.model.Team

/**
 * Created by Ziyad on Nov, 2019
 */
@Database(entities = [Team::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun teamDao(): TeamDao
}