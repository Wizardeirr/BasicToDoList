package com.volkankelleci.basictodolist.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [YapilacaklarDataClass::class], version = 1)
abstract class YapilacaklarDataBase : RoomDatabase() {

    abstract fun yapilacaklarDao(): YapilacaklarDao

    class Callback @Inject constructor(
        private val dataBase: Provider<YapilacaklarDataBase>,
        private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao=dataBase.get().yapilacaklarDao()
            applicationScope.launch {
                dao.insert(YapilacaklarDataClass("Dişlerini Fırçala"))
                dao.insert(YapilacaklarDataClass("Boya Alınacak",tik=true))
                dao.insert(YapilacaklarDataClass("Mustafayı Ara", tamamlandi = true))
                dao.insert(YapilacaklarDataClass("SKT yap"))
                dao.insert(YapilacaklarDataClass("Yemek ye", tamamlandi = false))
                dao.insert(YapilacaklarDataClass("Dişlerini Fırçala"))

            }

        }
    }
}