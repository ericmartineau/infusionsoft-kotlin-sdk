plugins {
  kotlin("jvm")
}

mverse {
  dependencies {
    compile("gson")
  }
}

dependencies {
  compile(project(":api-client-core-jvm"))
  testCompile("io.kotlintest:kotlintest:2.0.2")
}
