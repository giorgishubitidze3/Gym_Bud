package com.spearson.gymbud.domain.repository.model

import com.google.gson.annotations.SerializedName

data class GymExercise(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val instructions: List<String>,
    val name: String,
    val secondaryMuscles: List<String>,
    val target: String
)
