import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
    id("org.springframework.boot") version "2.3.3.RELEASE"

}
group = "me.tolyan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("org.springframework.boot:spring-boot-starter-websocket:2.3.3.RELEASE")
    implementation("org.springframework:spring-websocket:2.3.3.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-activemq:2.3.3.RELEASE")
    implementation("org.apache.activemq:activemq-stomp:5.8.0")
    implementation("org.apache.activemq:activemq-broker:5.16.0")
    implementation("io.projectreactor.netty:reactor-netty:0.9.12.RELEASE")
    implementation("com.thoughtworks.xstream:xstream:1.4.13")

}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}