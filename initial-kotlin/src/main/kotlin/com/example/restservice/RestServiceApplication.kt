package com.example.restservice

// SpringBootApplication: Spring Bootの自動設定を有効にするアノテーション
import org.springframework.boot.autoconfigure.SpringBootApplication
// runApplication: Kotlin用のSpring Boot起動ヘルパー関数
import org.springframework.boot.runApplication

/*
 * RestServiceApplication.kt - アプリケーションのエントリーポイント（起動点）（Kotlin版・初期状態）
 *
 * 【解説】
 * これはSpring Bootアプリケーションの「初期状態（initial）」のKotlin版です。
 * まだREST APIのエンドポイント（Greeting, GreetingController）は実装されていません。
 * complete-kotlin/ ディレクトリに完成版があります。
 *
 * @SpringBootApplication: Spring Bootの中核アノテーション。
 *   自動設定、コンポーネントスキャン、設定クラスの機能を兼ね備えています。
 *
 * Kotlinではクラス本体が空の場合、{} を省略できます。
 * main関数はクラスの外（トップレベル）に定義します。
 */
@SpringBootApplication
class RestServiceApplication

// Kotlinプログラムのエントリーポイント
// *args: スプレッド演算子で配列を個別の引数に展開
fun main(args: Array<String>) {
  runApplication<RestServiceApplication>(*args)
}
