package com.spearson.gymbud.di

import com.spearson.gymbud.data.json.ExerciseParser
import com.spearson.gymbud.data.json.JsonParser
import com.spearson.gymbud.data.repository.ExerciseRepositoryImpl
import com.spearson.gymbud.domain.repository.ExerciseRepository
import com.spearson.gymbud.domain.repository.model.GymExercise
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindExerciseParser(
        exerciseParser: ExerciseParser
    ): JsonParser<GymExercise>

    @Binds
    @Singleton
    abstract fun bindExerciseRepository(
        exerciseRepositoryImpl: ExerciseRepositoryImpl
    ): ExerciseRepository
}