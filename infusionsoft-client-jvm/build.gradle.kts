plugins {
  id("kotlinx-serialization")
  id("org.jetbrains.kotlin.jvm")
}

dependencies {
  compile(project(":api-client-core-jvm"))
  testCompile("io.kotlintest:kotlintest:2.0.2")
}
