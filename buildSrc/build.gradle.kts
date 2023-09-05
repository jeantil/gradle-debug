import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

// maybe move to a version catalog
// https://melix.github.io/blog/2021/03/version-catalogs.html
// https://melix.github.io/blog/2021/03/version-catalogs-faq.html#_can_i_use_the_version_catalog_in_buildsrc
// https://stackoverflow.com/questions/67795324/gradle7-version-catalog-how-to-use-it-with-buildsrc

val kotlinVersion="1.9.0"
val javaVersion="11"

dependencies {
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation(kotlin("allopen", kotlinVersion)) 
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.6.15")

    implementation("gradle.plugin.com.google.cloud.artifactregistry:artifactregistry-gradle-plugin:2.1.5")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlinDslPluginOptions {
    jvmTarget.set(javaVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = javaVersion
    }
}