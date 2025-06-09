import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("buildlogic.java-conventions")
    `maven-publish`
    id("com.gradleup.shadow")
}

dependencies {
    compileOnly("dev.pgm.paper:paper-api:1.8_1.21.5-SNAPSHOT")

    implementation(project(":util"))

    runtimeOnly(project(":platform-sportpaper")) { exclude("*") }
    runtimeOnly(project(":platform-modern")) { exclude("*") }
}

tasks.named<ShadowJar>("shadowJar") {
    archiveFileName = "MatchShare.jar"
    archiveClassifier.set("")
    destinationDirectory = rootProject.projectDir.resolve("build/libs")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    minimize {
        // Exclude from minimization as they're required at runtime
        exclude(project(":platform-sportpaper"))
        exclude(project(":platform-modern"))
    }

    dependencies {
        exclude(dependency("org.jetbrains:annotations"))
    }

    exclude("META-INF/**")
}

publishing {
    publications.create<MavenPublication>("MatchShare") {
        groupId = project.group as String
        artifactId = project.name
        version = project.version as String

        artifact(tasks["shadowJar"])
    }
}


val pluginProperties = mapOf(
    "description" to project.description,
    "mainClass" to "tc.oc.occ.matchshare.MatchShare",
    "version" to project.version,
    "commitHash" to project.latestCommitHash(),
    "author" to "applenick"
)

tasks {
    processResources {
        filesMatching(listOf("plugin.yml")) {
            expand(pluginProperties)
        }
    }

    named("jar") {
        enabled = false
    }

    named("build") {
        dependsOn(shadowJar)
    }
}