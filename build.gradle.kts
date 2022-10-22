val kotlin_version = "1.7.0"
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
    }
}
plugins {
    id("org.jetbrains.dokka") version "1.4.32"
    id("maven-publish")
    java
    `java-library`

    application
}
allprojects {
    apply(plugin = "org.gradle.java")
    apply(plugin = "org.gradle.java-library")
    apply(plugin = "com.github.johnrengelman.shadow")
    tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveFileName.set("${rootProject.name}.jar")
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.dmulloy2.net/repository/public/") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/public/") }
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://libraries.minecraft.net/") }
        maven { url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/") }
        maven { url = uri("https://raw.githubusercontent.com/MagicPluginTeam/maven-mirror/guiapi/") }

    }

    dependencies {
//        api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

        compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")

    }
}

