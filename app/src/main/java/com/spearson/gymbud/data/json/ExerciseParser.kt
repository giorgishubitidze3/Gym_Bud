package com.spearson.gymbud.data.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.spearson.gymbud.domain.repository.model.GymExercise
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseParser @Inject constructor(): JsonParser<GymExercise>{
    override suspend fun parse(json: String): List<GymExercise> {
        val type = object: TypeToken<List<GymExercise>>() {}.type
        return Gson().fromJson(json,type)
    }
}