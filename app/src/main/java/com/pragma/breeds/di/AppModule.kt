package com.pragma.breeds.di

import com.pragma.breeds.BuildConfig
import com.pragma.breeds.data.remote.ApiCats
import com.pragma.breeds.data.repository.CatRepositoryImpl
import com.pragma.breeds.domain.repository.CatRepository
import com.pragma.breeds.network.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun apiCats(retrofit: Retrofit): ApiCats = retrofit.create(ApiCats::class.java)

    @Provides
    @Singleton
    fun provides(
        apiCats: ApiCats
    ): CatRepository = CatRepositoryImpl(apiCats)
}