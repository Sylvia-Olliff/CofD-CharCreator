import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.sylvantitan.chargen"
version = "0.0.1"

repositories {
    mavenCentral()
}

javafx {
    version = "11.0.2"
    modules = mutableListOf("javafx.controls", "javafx.graphics")
}

kotlin {
    sourceSets {
        val main by getting {
            dependencies {
                implementation("no.tornado:tornadofx:1.7.20")
                implementation("io.swaydb:java_2.13:0.16.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
            }
        }
        val test by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "11"
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "11"
}