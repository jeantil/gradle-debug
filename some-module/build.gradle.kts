plugins {
    id("com.malt.library-conventions")
    id("java-test-fixtures")
}

dependencies {
    testFixturesImplementation(project(":test-utils"))
}