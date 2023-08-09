package com.atakan.quack.di

import com.atakan.quack.common.Constants
import com.atakan.quack.data.remote.DuckApi
import com.atakan.quack.data.repository.DuckRepositoryImpl
import com.atakan.quack.domain.repository.DuckRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDuckApi() : DuckApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DuckApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDuckRepository(api : DuckApi) : DuckRepository{
        return DuckRepositoryImpl(api)
    }
}