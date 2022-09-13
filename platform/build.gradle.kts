plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

extra["kotlinVersion"] = "1.6.20"
extra["springBootVersion"] = "2.6.9"
extra["testcontainersVersion"] = "1.17.1"

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}"))
    api(platform("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}"))
    constraints {
        api("org.jetbrains.kotlin:kotlin-reflect") {
            version {
                strictly("${property("kotlinVersion")}")
            }
        }
        api("org.jetbrains.kotlin:kotlin-stdlib") {
            version {
                strictly("${property("kotlinVersion")}")
            }
        }

        api("org.jetbrains.kotlin:kotlin-stdlib-common") {
            version {
                strictly("${property("kotlinVersion")}")
            }
        }
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
            version {
                strictly("${property("kotlinVersion")}")
            }
        }
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
            version {
                strictly("${property("kotlinVersion")}")
            }
        }
    }
}