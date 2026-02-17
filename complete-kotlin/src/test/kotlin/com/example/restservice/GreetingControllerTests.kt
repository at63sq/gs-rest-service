package com.example.restservice

// JUnit 5のテスト用アノテーション
import org.junit.jupiter.api.Test
// @Autowired: Springが必要なオブジェクトを自動注入するアノテーション
import org.springframework.beans.factory.annotation.Autowired
// テスト用REST APIクライアントを自動設定するアノテーション
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
// テスト時にSpringアプリケーション全体を起動するアノテーション
import org.springframework.boot.test.context.SpringBootTest
// REST APIテスト用のHTTPクライアント
import org.springframework.test.web.servlet.client.RestTestClient

/*
 * GreetingControllerTests.kt - GreetingControllerの自動テストクラス（Kotlin版）
 *
 * 【解説】
 * 自動テスト（ユニットテスト）は、コードが正しく動作することを自動的に確認する仕組みです。
 * 手動でブラウザからテストする代わりに、テストコードを実行して検証します。
 *
 * @SpringBootTest: テスト時にSpring Bootアプリ全体を起動
 * @AutoConfigureRestTestClient: REST APIテスト用のクライアントを自動設定
 *
 * Kotlinでは、テストメソッドの引数に @Autowired を付けて
 * RestTestClient を直接受け取ることができます（Javaではフィールドに注入するのが一般的）。
 */
@SpringBootTest
@AutoConfigureRestTestClient
class GreetingControllerTests {

  /*
   * テスト1: パラメータなしで /greeting にアクセスした場合
   * デフォルトの "Hello, World!" が返ることを確認
   */
  @Test
  fun noParamGreetingShouldReturnDefaultMessage(@Autowired restTestClient: RestTestClient) {
    restTestClient.get().uri("/greeting")       // GETリクエストを /greeting に送信
      .exchange()                                // リクエストを実行
      .expectStatus().isOk()                     // HTTPステータス200(OK)を期待
      .expectBody()                              // レスポンスボディを検証
      .jsonPath("$.content").isEqualTo("Hello, World!")  // JSONのcontentを検証
      // $.content = JSONPath記法。$ はルート、.content はプロパティ名
  }

  /*
   * テスト2: name パラメータに "Spring Community" を指定した場合
   * "Hello, Spring Community!" が返ることを確認
   */
  @Test
  fun paramGreetingShouldReturnTailoredMessage(@Autowired restTestClient: RestTestClient) {
    restTestClient.get()
      // Kotlinのラムダ式 { it.path(...) } でURIを組み立てる
      // it はラムダの暗黙の引数名（URIビルダーオブジェクト）
      .uri { it.path("/greeting").queryParam("name", "Spring Community").build() }
      .exchange()
      .expectStatus().isOk()
      .expectBody()
      .jsonPath("$.content").isEqualTo("Hello, Spring Community!")
  }

}
