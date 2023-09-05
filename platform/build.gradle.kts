plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {    
    api(platform(libs.spring.boot.dependencies))
    constraints {
        api(libs.kotlin.scripting.common)
        api(libs.testcontainers.core)
        api(libs.testcontainers.junit.jupiter)
        api(libs.postgresql)
    }
}