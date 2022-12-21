plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
    id(Plugins.kt_lint) version Versions.KT_LINT
}

android {
    namespace = ProjectProperties.APPLICATION_COMPONENTS
    compileSdk = ProjectProperties.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ProjectProperties.MIN_SDK_VERSION
        targetSdk = ProjectProperties.TARGET_SDK_VERSION

        testInstrumentationRunner = ProjectProperties.TEST_RUNNER
    }

    compileOptions {
        sourceCompatibility = ProjectProperties.JAVA_VERSION
        targetCompatibility = ProjectProperties.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.JVM_TARGET
    }
    buildFeatures {
        compose = ProjectProperties.BUILD_FEATURE_COMPOSE
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
    }
}

dependencies {
    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.LIFECYCLE_KTX)
    implementation(Compose.ACTIVITY_COMPOSE)
    implementation(Compose.UI_COMPOSE)
    implementation(Compose.UI_TOOLING_PREVIEW)
    implementation(Compose.MATERIAL_COMPOSE)
    testImplementation(UnitTest.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Compose.UI_TEST_JUNIT4)
    debugImplementation(Compose.UI_TOOLING)
    debugImplementation(Compose.UI_TEST_MANIFEST)
}

group = "com.github.Team-B1ND"
