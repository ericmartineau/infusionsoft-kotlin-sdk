plugins {
  id("kotlinx-serialization")
  id("org.jetbrains.kotlin.jvm")
}

mverse {
  dependencies {
    compile(kotlinStdlib())
    compile("kotlin-reflect")
    compile("gson")
  }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.10")
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.9.1")
    compile("com.squareup.okhttp3:okhttp:3.8.0")
    compile("org.threeten:threetenbp:1.3.6")
}
