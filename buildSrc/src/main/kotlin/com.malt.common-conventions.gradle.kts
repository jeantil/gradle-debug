import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.*
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    `java-library`
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.malt"
version = "3.5.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("file.encoding", "UTF-8")
    testLogging {
        events(FAILED, STANDARD_ERROR, SKIPPED)
        exceptionFormat = FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
        showStandardStreams = false
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=warn", "-Xemit-jvm-type-annotations")
        jvmTarget = "11"
    }
}

extra["springBootVersion"] = "2.6.15"
extra["testcontainersVersion"] = "1.17.1"

dependencies {
    api(platform(project(":platform")))
    annotationProcessor(platform(project(":platform")))
    runtimeOnly(platform(project(":platform")))
    testAnnotationProcessor(platform(project(":platform")))
    testImplementation(platform(project(":platform")))
    
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk7"))
    implementation(kotlin("stdlib-jdk8"))
}