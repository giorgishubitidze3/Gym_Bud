package com.spearson.gymbud.data.repository

import android.content.Context
import com.spearson.gymbud.data.json.JsonParser
import com.spearson.gymbud.domain.repository.ExerciseRepository
import com.spearson.gymbud.domain.model.GymExercise
import com.spearson.gymbud.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val exerciseParser: JsonParser<GymExercise>
): ExerciseRepository{

//    private val jsonString = context.assets.open("main.json").bufferedReader().use {
//        it.readText()
//    }

    override suspend fun getExercises(query: String): Flow<Resource<List<GymExercise>>> {
        return flow {
            emit(Resource.Loading(true))

            val exercises = withContext(Dispatchers.IO) {
                val jsonString = context.assets.open("main.json").bufferedReader().use { it.readText() }
                exerciseParser.parse(jsonString)
            }

            val filteredExercises = if (query.isBlank()) {
                exercises
            } else {
                exercises.filter { it.name.contains(query, ignoreCase = true) }
            }

            emit(Resource.Success(data = filteredExercises))

            emit(Resource.Loading(false))
        }
    }

//    override suspend fun getExercise(name: String): Resource<List<GymExercise>> {
//        val result = exerciseParser.parse(jsonString)
//        val filtered = result.filter{ it.name.contains(name, ignoreCase = true)}
//        return Resource.Success(data = filtered)
//    }
}