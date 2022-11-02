package com.ktn.pokemonpay.feature_pokemon.di

import com.ktn.pokemonpay.feature_pokemon.data.remote.PokemonApi
import com.ktn.pokemonpay.feature_pokemon.data.repository.PokemonRepositoryImp
import com.ktn.pokemonpay.feature_pokemon.domain.repository.PokemonRepository
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
    fun providePokemonApi(): PokemonApi{
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun providesPokemonRepository(api: PokemonApi): PokemonRepository{
        return PokemonRepositoryImp(api)
    }
}