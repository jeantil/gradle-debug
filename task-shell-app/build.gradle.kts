plugins {
    id("com.malt.app-conventions")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":task-persistence"))
    implementation(project(":task-domain"))

    implementation("org.liquibase:liquibase-core")
    implementation("org.springframework:spring-tx")
    implementation("org.springframework.shell:spring-shell-starter:2.0.0.RELEASE")

    testImplementation(testFixtures(project(":task-domain")))
    testImplementation(project(":test-utils"))
}
