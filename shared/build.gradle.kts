plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.apolloGraphQl)
    `maven-publish`
}

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

    repositories {
        maven {
            name = "sonatype"
            setUrl("https://central.sonatype.com/api/v1/publisher/deployment/ea9b3b0a-7ccb-4d90-9ca2-ecf885aa3288")
            credentials {
                username = "byronalberto"
                password = "Sx9eVrT3uUUPvpm"
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
            groupId = "io.github.byronalberto12"
            artifactId = "kt-multiplatform-bs-logic"
            version = "1.0.1"

            pom {
                name.set("kt-multiplatform-bs-logic")
                description.set("kt-multiplatform-bs-logic for Kotlin Multiplatform")
                url.set("https://github.com/ByronAlberto12/kt-multiplatform-bs-logic")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("ByronAlberto12")
                        name.set("Byron Solorzano")
                        email.set("byron.solorzano@multimoney.com")
                    }
                }
                scm {
                    url.set("https://github.com/ByronAlberto12/kt-multiplatform-bs-logic")
                }
            }
        }
    }
}

task("testClasses").doLast {
    println("This is a dummy testClasses task")
}

//tasks.register("generatePom") {
//    dependsOn(tasks.named("compileSharedLibrary"))
//    doLast {
//        val publications = project.publishing.publications
//        if (publications.isNotEmpty()) {
//            val mavenPublication = publications.findByName("maven")
//            mavenPublication?.pom?.writeTo(File("$buildDir/poms/kt-multiplatform-bs-logic.pom"))
//            println("Generated POM file: ${File("$buildDir/poms/kt-multiplatform-bs-logic.pom").absolutePath}")
//        } else {
//            println("No Maven publication found. Please configure Maven publication first.")
//        }
//    }
//}