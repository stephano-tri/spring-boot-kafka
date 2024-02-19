import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.spring") version "1.7.10"
}

group="eom.improve"
version="0.0.1-SNAPSHOT"

java {
    sourceCompatibility=JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.apache.kafka:kafka-streams")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("io.projectreactor.kafka:reactor-kafka:1.3.22")
    implementation("org.postgresql:r2dbc-postgresql:1.0.4.RELEASE")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")

    // for use kotlin jdsl reactive(Line corp)
    implementation("org.hibernate.reactive:hibernate-reactive-core-jakarta:1.1.9.Final")
    implementation("io.vertx:vertx-jdbc-client:4.3.1")
    implementation("io.agroal:agroal-pool:2.0")
    implementation("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-hibernate-reactive-jakarta:2.2.1.RELEASE")
    compileOnly("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("io.smallrye.reactive:mutiny-kotlin:1.6.0")
    // Resolve conflict to other hibernate versions
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude(module = "hibernate-core")
        exclude(module = "hibernate-commons-annotations")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs+="-Xjsr305=strict"
        jvmTarget="17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
