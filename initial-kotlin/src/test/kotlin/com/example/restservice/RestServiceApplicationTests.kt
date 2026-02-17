package com.example.restservice

// JUnit 5のテスト用アノテーション
import org.junit.jupiter.api.Test
// テスト時にSpringアプリケーション全体を起動するアノテーション
import org.springframework.boot.test.context.SpringBootTest

/*
 * RestServiceApplicationTests.kt - アプリケーション起動テスト（Kotlin版）
 *
 * 【解説】
 * Spring Bootアプリケーションが正常に起動できるかを確認するテストです。
 * contextLoads() の中身は空ですが、@SpringBootTest によりアプリケーション全体の
 * コンテキスト（設定やBean）が正しくロードされることを検証します。
 * 設定にエラーがあれば自動的にテストが失敗します。
 */
@SpringBootTest
class RestServiceApplicationTests {

  // アプリケーションコンテキストのロードテスト
  // 中身が空 = 例外が発生しなければ成功
  @Test
  fun contextLoads() {
  }

}
