package br.com.fiap.countries.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CountryDAO {
    @Query("SELECT * FROM $COUNTRY_MODEL_TABLE_NAME ORDER BY name")
    fun select(): List<CountryModel>

    @Insert
    fun inserir(countryModel: CountryModel)

    @Update
    fun update(countryModel: CountryModel)

    @Delete
    fun delete (contryModel: CountryModel)

}