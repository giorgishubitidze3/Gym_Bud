package com.spearson.gymbud.presentation.main.workouts

import com.spearson.gymbud.domain.model.GymExercise

data class WorkoutsState(
    val workouts: List<GymExercise> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
