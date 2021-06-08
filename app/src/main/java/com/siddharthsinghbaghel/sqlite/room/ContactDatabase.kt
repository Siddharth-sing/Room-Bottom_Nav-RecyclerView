package com.siddharthsinghbaghel.sqlite.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ContactEntity::class), version = 1, exportSchema = false)
public abstract class ContactRoomDatabase : RoomDatabase() {

    abstract fun getContactDao(): ContactDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ContactRoomDatabase? = null

        fun getDatabase(context: Context): ContactRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactRoomDatabase::class.java,
                    "contacts_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}