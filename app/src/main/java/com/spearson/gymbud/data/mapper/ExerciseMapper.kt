package com.spearson.gymbud.data.mapper

import com.spearson.gymbud.data.local.GymExerciseDto
import com.spearson.gymbud.domain.model.GymExercise

fun GymExerciseDto.toGymExercise(): GymExercise {
    return GymExercise(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        instructions = instructions,
        name = name,
        secondaryMuscles = secondaryMuscles,
        target = target
    )
}
