plugins {
    id("com.android.library")
    kotlin("multiplatform") version "1.4.30"
    id("maven-publish")
    signing
}

repositories {
    google()
    jcenter()
    mavenCentral()
}

kotlin {

    android {
        publishLibraryVariants("release", "debug")
    }

    iosArm64() {
        binaries {
            framework()
        }
    }

    iosX64() {
        binaries {
            framework()
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.4.30")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
            }
        }

        val iosArm64Main by getting

        val iosX64Main by getting

    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

apply(from = "publish.gradle.kts")