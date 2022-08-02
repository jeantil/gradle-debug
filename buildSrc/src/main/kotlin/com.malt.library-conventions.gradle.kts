import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.malt.common-conventions")
}

pluginManager.withPlugin("java-test-fixtures") {
    // makes testFixtures "friends" with src/main so
    // testFixtures can access interals from production
    // code
    // cf https://youtrack.jetbrains.com/issue/KT-34901
    kotlin.target.compilations.getByName("test") {
        associateWith(target.compilations.getByName("testFixtures"))
    }
    kotlin.target.compilations.getByName("testFixtures") {
        associateWith(target.compilations.getByName("main"))
    }
}