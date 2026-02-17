package com.example.restservice

// SpringBootApplication: Spring Bootの自動設定を有効にするアノテーション
import org.springframework.boot.autoconfigure.SpringBootApplication
// runApplication: Kotlinの拡張関数で、SpringApplication.run() をより簡潔に呼べる
import org.springframework.boot.runApplication

/*
 * RestServiceApplication.kt - アプリケーションのエントリーポイント（起動点）（Kotlin版）
 *
 * 【解説】
 * @SpringBootApplication: Spring Bootの中核となるアノテーション。
 *   以下の3つの機能を1つにまとめています：
 *   1. @Configuration      : Bean（部品）の定義を含むクラスであることを示す
 *   2. @EnableAutoConfiguration : ライブラリに基づく自動設定を有効にする
 *   3. @ComponentScan      : このパッケージ以下のクラスを自動検出・登録する
 *
 * Kotlinでは、クラス本体が空の場合は {} を省略できます。
 * また、main関数はクラスの外（トップレベル）に定義します。
 * これはJavaと異なり、Kotlinではクラスに属さない関数を書けるためです。
 */
@SpringBootApplication
class RestServiceApplication

// Kotlinプログラムのエントリーポイント（最初に実行される関数）
// args: コマンドライン引数の配列
// *args: スプレッド演算子。配列を個別の引数として展開して渡す
fun main(args: Array<String>) {
  // runApplication はKotlin用のヘルパー関数。
  // <RestServiceApplication> は型パラメータ（ジェネリクス）で、起動するクラスを指定。
  runApplication<RestServiceApplication>(*args)
}
