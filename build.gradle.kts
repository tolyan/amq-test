import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id ("org.springframework.boot") version "2.3.2.RELEASE"
    id ("io.spring.dependency-management") version "1.0.8.RELEASE"
    id ("java")
    kotlin("jvm") version "1.4.10"
}

group = "prototype"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}


repositories {
    mavenCentral()
}

dependencies {
    implementation( "org.springframework.boot:spring-boot-starter-websocket")
    implementation( "org.webjars:webjars-locator-core")
    implementation( "org.webjars:sockjs-client:1.0.2")
    implementation("org.webjars:stomp-websocket:2.3.3")
    implementation( "org.webjars:bootstrap:3.3.7")
    implementation( "org.webjars:jquery:3.1.1-1")
    implementation("org.apache.activemq:activemq-stomp:5.8.0")
    implementation("org.apache.activemq:activemq-broker:5.16.0")
    implementation("io.projectreactor.netty:reactor-netty:0.9.12.RELEASE")
    implementation("com.thoughtworks.xstream:xstream:1.4.13")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude (group="org.junit.vintage", module="junit-vintage-engine")
    }
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}