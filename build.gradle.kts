plugins {
  id("io.mverse.project") version "0.5.32"
  id("io.mverse.multi-platform") version "0.5.32"
  id("org.jetbrains.kotlin.jvm").version("1.3.10")
  id("kotlinx-serialization").version("1.3.10")
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
      dependencySet("org.jetbrains.kotlin:1.3.10") {
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

