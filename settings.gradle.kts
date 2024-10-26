rootProject.name = "JunkTools"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

mapOf(
    "junk-ts" to listOf("",
        ":converter",
        ":wrapper",
        ":gradle-plugin",
    ),
    "junk-graal" to listOf("",
        ":gradle-plugin",
    ),
).forEach { (parent, subprojects) ->
    subprojects.forEach {
        include(":$parent$it")
    }
}
