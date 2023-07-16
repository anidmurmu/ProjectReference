package com.example.domain.usecase.university.di

import com.example.domain.repositories.university.UniversityRepository
import com.example.domain.usecase.university.GetUniversityDetailsListUseCase
import com.example.domain.usecase.university.GetUniversityDetailsListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class GetUniversityDetailsListUseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetUniversityDetailsListUseCase(
        universityRepository: UniversityRepository
    ): GetUniversityDetailsListUseCase {
        return GetUniversityDetailsListUseCaseImpl(universityRepository)
    }
}