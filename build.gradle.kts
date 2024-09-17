// Top-level build file where you can add configuration options common to all sub-projects/modules.
configurations.all {
    resolutionStrategy.eachDependency {
        when {
            requested.name == "javapoet" -> useVersion("1.13.0")
        }
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias (libs.plugins.hilt.application) apply false
}
//id("com.google.dagger.hilt.android") version "2.51.1" apply false