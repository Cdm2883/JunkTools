import com.github.gradle.node.npm.task.NpmTask

plugins {
    alias(libs.plugins.gradle.node)
}

tasks.register<Delete>("invaildCache") {
    group = "build"
    delete(file("node_modules"))
    finalizedBy("clean")
}
tasks.register<NpmTask>("clean") {
    group = "build"
    dependsOn(tasks.npmInstall)
    npmCommand = listOf("run", "clear")
}

tasks.register<NpmTask>("build") {
    group = "build"
    dependsOn("clean")
    npmCommand = listOf("run", "build")
}
