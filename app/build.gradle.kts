/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.3.1/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    checkstyle
    id("com.github.spotbugs") version "5.0.5"
    // Adds task 'shadowJar ' to export a runnable jar .
    // The runnable jar will be found in build / libs / projectname - all . jar
    id ("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

val javaFXModules = listOf("base", "controls", "fxml", "swing", "graphics")
val supportedPlatforms = listOf("linux", "mac", "win")
val javaFXVersion = 15

dependencies {
    spotbugs("com.github.spotbugs:spotbugs:4.5.3")
    spotbugsPlugins("com.h3xstream.findsecbugs:findsecbugs-plugin:1.11.0")
    
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:$javaFXVersion:$platform")
        }
    }

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.platform:junit-platform-runner:1.8.2")
    // https://mvnrepository.com/artifact/org.junit.platform/junit-platform-commons
    implementation("org.junit.platform:junit-platform-commons:1.8.2")
    // https://mvnrepository.com/artifact/org.junit.platform/junit-platform-launcher
    testImplementation("org.junit.platform:junit-platform-launcher:1.8.2")

    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.12.0")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1.1-jre")
}

application {
    // Define the main class for the application.
    mainClass.set("casim.App")
}

checkstyle {
    
}

spotbugs {
    ignoreFailures.set(true)
    showStackTraces.set(true)
    showProgress.set(true)
    effort.set(com.github.spotbugs.snom.Effort.DEFAULT)
    reportLevel.set(com.github.spotbugs.snom.Confidence.LOW)
    reportsDir.set(file("$buildDir/reports/spotbugs"))
    excludeFilter.set(file("../config/spotbugs/excludes.xml"))
}

//Configure Spotbugs Report
tasks.spotbugsMain {
    reports.create("xml") {
        required.set(true)
        outputLocation.set(file("$buildDir/reports/spotbugs/spotbugs.xml"))
    }
}

//Java version
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

//Configure JUnit
tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
		events("skipped", "failed")
	}
}

tasks.named("check") {
    dependsOn("javadoc")
}