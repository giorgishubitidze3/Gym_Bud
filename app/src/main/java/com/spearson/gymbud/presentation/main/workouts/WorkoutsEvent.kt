package com.spearson.gymbud.presentation.main.workouts

sealed class WorkoutsEvent {
    data class OnSearchQueryChange(val query: String) : WorkoutsEvent()
}