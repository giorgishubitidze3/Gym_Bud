package com.spearson.gymbud.domain.repository

import com.spearson.gymbud.data.local.GymExerciseDto
import com.spearson.gymbud.domain.model.GymExercise
import com.spearson.gymbud.util.Resource
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    suspend fun getExercises(query: String): Flow<Resource<List<GymExercise>>>

//    suspend fun getExercise(name: String): Resource<List<GymExercise>>
}