object Kotlin {
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
}

object AndroidX {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"
}

object UnitTest {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
}

object AndroidTest {
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}

object Compose {
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val UI_COMPOSE = "androidx.compose.ui:ui:${Versions.COMPOSE_VERSION}"
    const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_VERSION}"
    const val MATERIAL_COMPOSE = "androidx.compose.material:material:${Versions.MATERIAL_COMPOSE}"
    const val UI_TEST_JUNIT4 = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_VERSION}"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_VERSION}"
    const val UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE_VERSION}"
    const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE_VERSION}"
    const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}"
}

object Gradle {
    const val MAVEN_GRADLE_PLUGIN = "com.github.dcendents:android-maven-gradle-plugin:${Versions.MAVEN_GRADLE_PLUGIN}"
}