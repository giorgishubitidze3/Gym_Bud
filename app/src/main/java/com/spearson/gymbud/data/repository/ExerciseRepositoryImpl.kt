package com.spearson.gymbud.data.repository

import android.content.Context
import com.spearson.gymbud.data.json.JsonParser
import com.spearson.gymbud.domain.repository.ExerciseRepository
import com.spearson.gymbud.domain.repository.model.GymExercise
import com.spearson.gymbud.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val exerciseParser: JsonParser<GymExercise>
): ExerciseRepository{

    private val jsonString = context.assets.open("main.json").bufferedReader().use {
        it.readText()
    }

    override suspend fun getExercises(): Flow<Resource<List<GymExercise>>> {
//        return exerciseParser.parse(jsonString)
        return flow{
            emit(Resource.Loading(true))
            val result = exerciseParser.parse(jsonString)
            emit(Resource.Success(data = result))
        }
    }

    override suspend fun getExercise(name: String): Resource<List<GymExercise>> {
        val result = exerciseParser.parse(jsonString)
        val filtered = result.filter{ it.name.contains(name, ignoreCase = true)}
        return Resource.Success(data = filtered)
    }

}