buildscript {
    dependencies {
        classpath(Gradle.MAVEN_GRADLE_PLUGIN)
    }
}

plugins {
    id (Plugins.androidApplication).version(ProjectProperties.ANDROID_VERSION).apply(false)
    id (Plugins.androidLibrary).version(ProjectProperties.ANDROID_VERSION).apply(false)
    id (Plugins.jetbrainsKotlinAndroid).version(ProjectProperties.JETBRAINS_KOTLIN).apply(false)
    id (Plugins.jetbrainsKotlinJvm).version(ProjectProperties.JETBRAINS_KOTLIN).apply(false)
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}