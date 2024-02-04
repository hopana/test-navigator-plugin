buildscript {
    repositories {
        mavenLocal()
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/releases/") }
        maven { url = uri("https://dl.bintray.com/jetbrains/intellij-plugin-service") }
        maven { url = uri("https://dl.bintray.com/jetbrains/intellij-third-party-dependencies/") }
    }
    dependencies {
        classpath("org.jetbrains.intellij.plugins:gradle-intellij-plugin:1.7.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

plugins {
    id("java")
    kotlin("jvm") version "1.7.0"
    id("org.jetbrains.intellij") version "1.7.0"
}

intellij {
    type.set("IU")
    version.set("2021.1.3")
    plugins.set(
        listOf(
            "java",
            "Kotlin",
            "Groovy",
        )
    )
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.mockito:mockito-core:5.10.0")
}
