package com.spearson.gymbud.presentation.workouts

sealed class WorkoutsEvent {
    data class OnSearchQueryChange(val query: String) : WorkoutsEvent()
}