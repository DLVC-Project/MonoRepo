/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    java
    `maven-publish`
}

//mainClassName = kotlin/dlvc/manager/playerloader/PlayerLoaderApplication.kt

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.2")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.2")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.21")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.21")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.7.3")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:2.7.2")
    runtimeOnly("com.h2database:h2:2.1.214")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.2")
}

group = "dlvc.manager"
version = "0.0.1-SNAPSHOT"
description = "PlayerLoader"
java.sourceCompatibility = JavaVersion.VERSION_1_8

//publishing {
//    publications.create<MavenPublication>("maven") {
//        from(components["java"])
//    }
//}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}