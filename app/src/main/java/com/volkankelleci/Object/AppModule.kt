package com.volkankelleci.Object

import android.app.Application
import androidx.room.Room
import com.volkankelleci.basictodolist.data.YapilacaklarDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponentManager::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataBase(
        app: Application,
        callback:YapilacaklarDataBase.Callback
    ) = Room.databaseBuilder(app, YapilacaklarDataBase::class.java, "yapilacaklar_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()
    @Provides
    fun provideYapilacaklarDao(db:YapilacaklarDataBase)= db.yapilacaklarDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope()= CoroutineScope(SupervisorJob())
}
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope
