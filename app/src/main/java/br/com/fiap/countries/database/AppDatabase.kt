package br.com.fiap.countries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val COUNTRY_DATABASE_NAME = "COUNTRY_DATABASE_NAME"

@Database(entities = [CountryModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun countryDAO(): CountryDAO

    companion object {
        private var INSTANCE: AppDatabase?  = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: let {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    COUNTRY_DATABASE_NAME
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

}