/*
 * build.gradle.kts - Gradleビルド設定ファイル（initial版・Kotlin）
 *
 * 【解説】
 * 初期状態（initial）のKotlin版ビルドファイルです。
 * complete-kotlin版と同じ依存関係を持ちますが、REST APIエンドポイントは未実装です。
 */

plugins {
  kotlin("jvm") version "2.2.21"             // Kotlin JVMプラグイン
  kotlin("plugin.spring") version "2.2.21"   // Spring用Kotlinプラグイン
  id("org.springframework.boot") version "4.0.1"  // Spring Bootプラグイン
  id("io.spring.dependency-management") version "1.1.7"  // バージョン管理
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(17)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webmvc")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
