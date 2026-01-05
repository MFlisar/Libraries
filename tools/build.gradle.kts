plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    sourceSets {

        val main by getting {
            dependencies {

                implementation(libs.kotlinx.serialization.json)
                implementation(deps.flexmark)
            }
        }
    }
}

tasks.register<JavaExec>("updateDocs") {
    mainClass.set("UpdateDocsKt")
    classpath = sourceSets["main"].runtimeClasspath
}