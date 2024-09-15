package com.spearson.gymbud.domain.repository

import com.spearson.gymbud.data.local.GymExerciseDto
import com.spearson.gymbud.domain.repository.model.GymExercise
import com.spearson.gymbud.util.Resource
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    suspend fun getExercises(): Flow<Resource<List<GymExercise>>>

    suspend fun getExercise(name: String): Resource<List<GymExercise>>
}