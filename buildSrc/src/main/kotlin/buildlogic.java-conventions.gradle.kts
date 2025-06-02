plugins {
    `java-library`
    id("com.diffplug.spotless")
    id("de.skuzzle.restrictimports")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/") // Snapshots
    maven("https://repo.pgm.fyi/snapshots/") // PGM-specific depdencies
}

dependencies {
    api("tc.oc.occ:Dispense:1.0.0-SNAPSHOT")

    compileOnly("dev.pgm.community:core:0.2-SNAPSHOT")
    compileOnly("dev.pgm.paper:paper-api:1.8_1.21.5-SNAPSHOT")
    compileOnly("tc.oc.pgm:core:0.16-SNAPSHOT")
    compileOnly("tc.oc.pgm:util:0.16-SNAPSHOT")
    compileOnly("tc.oc.occ:Dewdrop:1.0.0-SNAPSHOT")
    compileOnly("tc.oc.occ:Environment:1.0.0-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:26.0.2")

    compileOnly("com.google.guava:guava:17.0")
}

group = "tc.oc.occ.matchshare"
version = "2.0.0-SNAPSHOT"
description = "A Minecraft plugin to wrap PGM events/data"

tasks {
    withType<JavaCompile>() {
        options.encoding = "UTF-8"
    }
    withType<Javadoc>() {
        options.encoding = "UTF-8"
    }
}

spotless {
    ratchetFrom = "a007e1fa4a53d1d915bea3cf2617070b2d96e0c5"
    java {
        removeUnusedImports()
        palantirJavaFormat("2.67.0").style("GOOGLE").formatJavadoc(true)
    }
}

restrictImports {
    group {
        reason = "Use org.jetbrains.annotations to add annotations"
        bannedImports = listOf("javax.annotation.**")
    }
    group {
        reason = "Use tc.oc.pgm.util.Assert to add assertions"
        bannedImports = listOf("com.google.common.base.Preconditions.**", "java.util.Objects.requireNonNull")
    }
}