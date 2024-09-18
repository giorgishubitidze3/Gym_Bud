package com.spearson.gymbud.presentation.workouts.workouts_detail

import com.spearson.gymbud.domain.model.GymExercise

data class WorkoutDetailState (
    val exercise: GymExercise? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)