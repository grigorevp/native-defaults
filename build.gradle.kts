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
        publishLibraryVariants("release")
    }
    iosX64("ios") {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.3.0")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].java.srcDirs("src/androidMain/kotlin")
    sourceSets["main"].resources.srcDirs("src/androidMain/resources")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}

apply(from = "publish.gradle.kts")