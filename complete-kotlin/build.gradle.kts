/*
 * build.gradle.kts - Gradleビルド設定ファイル（complete版・Kotlin）
 *
 * 【解説】
 * .kts 拡張子は「Kotlin Script」を意味します。
 * Gradleのビルドファイルは Groovy（build.gradle）または Kotlin（build.gradle.kts）で記述できます。
 * Kotlin版は型安全で、IDEの補完が効きやすいという利点があります。
 */

// plugins: プロジェクトに追加する機能を宣言
plugins {
  kotlin("jvm") version "2.2.21"             // Kotlin JVMプラグイン（KotlinをJVM上で動かす）
  kotlin("plugin.spring") version "2.2.21"   // Spring用Kotlinプラグイン（クラスをopenにする等）
  id("org.springframework.boot") version "4.0.1"  // Spring Bootプラグイン
  id("io.spring.dependency-management") version "1.1.7"  // 依存関係バージョン管理
}

group = "com.example"       // 組織の識別子
version = "0.0.1-SNAPSHOT"  // バージョン（開発中）

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(17)  // Java 17を使用
  }
}

repositories {
  mavenCentral()  // ライブラリのダウンロード元
}

// 依存ライブラリの宣言
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webmvc")  // Web MVC本体
  // jackson-module-kotlin: KotlinのデータクラスをJSON変換するために必要
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  // kotlin-reflect: Kotlinのリフレクション（実行時の型情報取得）ライブラリ
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")  // テスト用
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")  // Kotlin用JUnit5テスト
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")  // JUnit5実行エンジン
}

// Kotlinコンパイラの設定
kotlin {
  compilerOptions {
    freeCompilerArgs.addAll(
      "-Xjsr305=strict",  // Java のnullability アノテーションを厳密に扱う
      "-Xannotation-default-target=param-property"  // アノテーションのデフォルトターゲットを設定
    )
  }
}

// テスト実行設定
tasks.withType<Test> {
  useJUnitPlatform()  // JUnit 5でテスト実行
}
