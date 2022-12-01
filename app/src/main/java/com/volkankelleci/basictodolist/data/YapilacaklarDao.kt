package com.volkankelleci.basictodolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import java.util.concurrent.Flow

@Dao
interface YapilacaklarDao {

    @Query("SELECT*FROM yapilacaklar_tablosu")
    fun yapilacaklariAl():kotlinx.coroutines.flow.Flow<YapilacaklarDataClass>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (dataBase:YapilacaklarDataClass)
    @Update
    suspend fun update(dataBase: YapilacaklarDataClass)
    @Delete
    suspend fun delete(dataBase: YapilacaklarDataClass)
}