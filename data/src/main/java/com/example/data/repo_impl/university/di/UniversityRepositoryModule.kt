package com.example.data.repo_impl.university.di

import com.example.data.mapper.university.UniversityMapper
import com.example.data.repo_impl.university.UniversityRepoImpl
import com.example.data.source.network.university.UniversityApiClient
import com.example.domain.repositories.university.UniversityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UniversityRepositoryModule {

        @Provides
        @ActivityRetainedScoped
        fun provideUniversityRepository(
            /*universityApiClient: UniversityApiClient,
            universityMapper: UniversityMapper*/
        ): UniversityRepository {
            return UniversityRepoImpl(/*universityApiClient, universityMapper*/)
        }
}