package com.example.morty_app.feature_morty.di

import com.example.morty_app.core.Constants
import com.example.morty_app.feature_morty.data.remote.MortyApi
import com.example.morty_app.feature_morty.data.repository.CharacterRepositoryImpl
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
    fun provideMortyApi(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): MortyApi = retrofit.create(MortyApi::class.java)


    @Provides
    @Singleton
    fun provideCharacterRepository(api: MortyApi): CharacterRepository{
        return CharacterRepositoryImpl(api)
    }
}