plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
    id(Plugins.kt_lint) version Versions.KT_LINT
    id(Plugins.maven)
}

publishing {
    publications {
        create<MavenPublication>(ProjectProperties.PUBLISHING_NAME) {
            groupId = ProjectProperties.APPLICATION_COMPONENTS
            artifactId = ProjectProperties.COMPONENT_ARTIFACT_ID
            version = ProjectProperties.COMPONENT_VERSION

            artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
        }
    }
}

android {
    namespace = ProjectProperties.APPLICATION_COMPONENTS
    compileSdk = ProjectProperties.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ProjectProperties.MIN_SDK_VERSION
        targetSdk = ProjectProperties.TARGET_SDK_VERSION

        testInstrumentationRunner = ProjectProperties.TEST_RUNNER
    }

    buildTypes {
        getByName(ProjectProperties.APPLICATION_BUILD_TYPE) {
            isMinifyEnabled = ProjectProperties.IS_MINIFY_ENABLE
            proguardFiles(getDefaultProguardFile(ProjectProperties.PROGUARD_NAME), ProjectProperties.PROGUARD_FILE)
        }
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
    implementation(Compose.FOUNDATION)

    // 최소한으로 사용!!!!!!!!!
    implementation(Compose.MATERIAL_COMPOSE)

    implementation(Compose.UI_TOOLING_PREVIEW)
    testImplementation(UnitTest.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Compose.UI_TEST_JUNIT4)
    debugImplementation(Compose.UI_TOOLING)
    debugImplementation(Compose.UI_TEST_MANIFEST)

    // Pager
    implementation(Compose.PAGER_COMPOSE)
    implementation(Compose.PAGER_INDICATORS_COMPOSE)

    // Landscapist-glide
    implementation(Compose.LANDSCAPIST_COMPOSE)
    implementation(Compose.LANDSCAPIST_PLACEHOLDER_COMPOSE)
}
