plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

group = "com.example"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor
    implementation(libs.bundles.ktor)

    // Exposed
    implementation(libs.bundles.exposed)

    // Logging
    implementation(libs.logback.classic)


    // DB Drivers
    implementation(libs.postgresql)

    // Flyway
    implementation(libs.flyway.core)
    implementation(libs.flyway.database.postgresql)

    // DateTime
    implementation(libs.kotlinx.datetime)

    // Cryptography
    implementation(libs.cryptography.core)
    implementation(libs.cryptography.random)

    // Koin
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)


    // Test
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
