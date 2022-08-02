rootProject.name = "malt"

var excludeDirs = setOf(
    // Exclude non project
    "buildSrc",
    ".node_modules",
    "build",
    "bin",
    "target",
    ".git",
    ".idea",
    ".gradle",
)
var registeredProjectNb = 0
fun includeAllModules(dir: File) {
    dir.listFiles()
        ?.filter { it.isDirectory }
        ?.filter { !excludeDirs.contains(it.name) }
        ?.forEach {
            if (it.listFiles()?.any { it.name.equals("build.gradle.kts") } == true) {
                include(it.name)

                project(":${it.name}").projectDir = it.absoluteFile
                registeredProjectNb++
                includeAllModules(it)
            }
        }
}

includeAllModules(file("."))