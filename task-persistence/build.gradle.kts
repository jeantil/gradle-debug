plugins {
    id("com.malt.library-conventions")
}

dependencies {
    implementation(project(":some-module"))
    implementation(project(":task-domain"))
    
    implementation("javax.inject:javax.inject:1")
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    testImplementation(testFixtures(project(path = ":task-domain")))
    testImplementation(project(":test-utils"))
}

