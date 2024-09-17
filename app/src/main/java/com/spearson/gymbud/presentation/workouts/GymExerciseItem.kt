package com.spearson.gymbud.presentation.workouts

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.spearson.gymbud.domain.model.GymExercise

@Composable
fun GymExerciseItem(
    workout: GymExercise,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = workout.name)
    }
}