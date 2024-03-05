plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.apolloGraphQl)
    `maven-publish`
}
group = "io.github.byronalberto12"
version = "1.0.0"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "0.0.9"
        license = "LICENSE"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.graphql)
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.multimoney.multimoney_bussines_logic"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

apollo {
    service("service") {
        packageName.set("com.multimoney")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "kt-multiplatform-bs-logic"
            pom {
                name.set("kt-multiplatform-bs-logic")
                description.set("kt-multiplatform-bs-logic for Kotlin Multiplatform")
            }
        }
    }
}