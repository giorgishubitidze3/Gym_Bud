package com.spearson.gymbud.presentation.main.workouts.workouts_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getDrawable
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.spearson.gymbud.R
import com.spearson.gymbud.domain.model.GymExercise



@Composable
fun WorkoutDetailScreen(
    exercise: GymExercise,
    viewModel: WorkoutDetailViewModel = hiltViewModel()
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){

        Image(
            painter = rememberDrawablePainter(
                drawable = getDrawable(
                    LocalContext.current,
                    viewModel.getDrawableResourceByName(exercise.gifUrl)
                )
            ),
            contentDescription = "Loading animation",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.clip(RoundedCornerShape(percent = 10))
        )

        Spacer(Modifier.height(4.dp))

        Text(
            fontSize = 28.sp,
            text = exercise.name
        )

        Spacer(Modifier.height(4.dp))

        Text(
            fontSize = 24.sp,
            text = exercise.bodyPart
        )

        Spacer(Modifier.height(4.dp))

        Text(
            fontSize = 18.sp,
            text = exercise.instructions.mapIndexed{ index, instruction -> "${index + 1}. $instruction" }.joinToString(separator = "\n"),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}