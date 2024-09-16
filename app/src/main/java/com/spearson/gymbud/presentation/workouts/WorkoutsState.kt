package com.spearson.gymbud.presentation.workouts

import com.spearson.gymbud.domain.repository.model.GymExercise

data class WorkoutsState(
    val workouts: List<GymExercise> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
