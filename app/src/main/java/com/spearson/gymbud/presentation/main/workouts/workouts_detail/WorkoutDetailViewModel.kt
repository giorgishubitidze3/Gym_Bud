package com.spearson.gymbud.presentation.main.workouts.workouts_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spearson.gymbud.util.DrawableHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val drawableHelper: DrawableHelper,
): ViewModel(){
    var state by mutableStateOf(WorkoutDetailState())


    fun getDrawableResourceByName(name: String): Int {
        return drawableHelper.getDrawableResourceByName(name)
    }

}