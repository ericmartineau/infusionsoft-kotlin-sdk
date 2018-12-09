plugins {
  id("io.mverse.project") version "0.5.32"
  id("io.mverse.multi-platform") version "0.5.32"
  id("kotlinx-serialization").version("1.3.10")
  id("org.jetbrains.kotlin.jvm").version("1.3.10")
}

group = "io.mverse.client.infusionsoft"
version = "1.0.0"

mverse {
  isDefaultDependencies = false
  coverageRequirement = 0.0
}

repositories {
  jcenter()
  maven("https://kotlin.bintray.com/kotlinx")
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.10")
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.9.1")
    compile("com.squareup.okhttp3:okhttp:3.8.0")
    compile("org.threeten:threetenbp:1.3.6")
    testCompile("io.kotlintest:kotlintest:2.0.2")
}
