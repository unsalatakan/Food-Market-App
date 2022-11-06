package com.atakan.foodmarkethub.di

import com.atakan.foodmarkethub.data.repo.YemeklerDaoRepository
import com.atakan.foodmarkethub.retrofit.ApiUtils
import com.atakan.foodmarkethub.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDaoRepository(ydao: YemeklerDao): YemeklerDaoRepository {
        return YemeklerDaoRepository(ydao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao(): YemeklerDao {
        return ApiUtils.getYemeklerDao()
    }
}