plugins {
  id("io.mverse.project") version "0.5.35"
  id("io.mverse.multi-platform") version "0.5.35"
  id("org.jetbrains.kotlin.jvm").version("1.3.21")
  id("kotlinx-serialization").version("1.3.21")
}

allprojects {
  group = "io.mverse.client.infusionsoft"

  mverse {
    isDefaultDependencies = false
    coverageRequirement = 0.0
  }

  repositories {
    jcenter()
    maven("https://kotlin.bintray.com/kotlinx")
  }

  dependencyManagement {
    dependencies {

      // Google Gson library
      dependency("com.google.code.gson:gson:2.8.5")

      val ktor: String by project
      dependency("io.ktor:ktor-client-core:$ktor")
      dependency("io.ktor:ktor-client-cio:$ktor")
      dependency("io.ktor:ktor-client-json:$ktor")
      dependency("io.ktor:ktor-client-gson:$ktor")

      dependencySet("org.jetbrains.kotlin:1.3.21") {
        entry("kotlin-stdlib")
        entry("kotlin-runtime")
        entry("kotlin-stdlib-common")
        entry("kotlin-stdlib-jdk7")
        entry("kotlin-stdlib-jdk8")
        entry("kotlin-reflect")
        entry("kotlin-test-annotations-common")
        entry("kotlin-test")
        entry("kotlin-test-junit")
      }
    }
  }
}

