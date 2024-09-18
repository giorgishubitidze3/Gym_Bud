package com.spearson.gymbud.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DrawableHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getDrawableResourceByName(name: String): Int {
        val resourceId = context.resources.getIdentifier(name, "drawable", context.packageName)
        return if (resourceId != 0) resourceId else getDefaultDrawableId()
    }

    private fun getDefaultDrawableId(): Int {
        return context.resources.getIdentifier("default_exercise", "drawable", context.packageName)
    }
}