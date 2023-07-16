package com.example.data.source.network.university.di

import com.example.data.source.network.university.UniversityApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
class UniversityApiClientModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUniversityApiClient(
        retrofit: Retrofit
    ): UniversityApiClient {
        return retrofit.create(UniversityApiClient::class.java)
    }
}