package com.spearson.gymbud.presentation.workouts.workouts_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){
    var state by mutableStateOf(WorkoutDetailState())



}