plugins {
  kotlin("jvm")
}

mverse {
  dependencies {
    compile(kotlinStdlib())
    compile("kotlin-reflect")
    compile("gson")
    compile("ktor-client-core")
    compile("ktor-client-cio")
    compile("ktor-client-json")
    compile("ktor-client-gson")
  }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.10")
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.9.1")
}
