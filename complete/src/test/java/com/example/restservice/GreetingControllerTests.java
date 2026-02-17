package com.example.restservice;

// JUnit 5のテスト用アノテーション。テストメソッドに付ける。
import org.junit.jupiter.api.Test;

// @Autowired: Springが自動的に必要なオブジェクトを注入（DI: Dependency Injection）するためのアノテーション
import org.springframework.beans.factory.annotation.Autowired;
// テスト用のREST APIクライアントを自動設定するアノテーション
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
// テスト時にSpringアプリケーション全体を起動するアノテーション
import org.springframework.boot.test.context.SpringBootTest;
// REST APIのテストを行うためのクライアントクラス
import org.springframework.test.web.servlet.client.RestTestClient;

/*
 * GreetingControllerTests.java - GreetingControllerの自動テストクラス
 *
 * 【解説】
 * ソフトウェア開発では「テスト」が非常に重要です。
 * 手動でブラウザからアクセスして確認する代わりに、テストコードを書いて
 * 自動的に動作確認を行います。これを「自動テスト」または「ユニットテスト」と呼びます。
 *
 * @SpringBootTest: テスト実行時にSpring Bootアプリケーション全体を起動します。
 *   実際のサーバーと同じ環境でテストできます。
 *
 * @AutoConfigureRestTestClient: REST APIをテストするためのHTTPクライアント
 *   （RestTestClient）を自動的に用意してくれます。
 *
 * テストメソッドには @Test アノテーションを付けます。
 * テストが成功すれば何も起きず、失敗するとエラーが報告されます。
 */
@SpringBootTest
@AutoConfigureRestTestClient
public class GreetingControllerTests {

  // @Autowired により、SpringがRestTestClientのインスタンスを自動的に用意して注入する
  // DI（依存性注入）: 必要なオブジェクトを外部から渡す設計パターン
  @Autowired
  private RestTestClient restTestClient;

  /*
   * テスト1: パラメータなしでアクセスした場合、デフォルトの挨拶が返ることを確認
   * GET /greeting → {"content": "Hello, World!"} を期待
   */
  @Test
  public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

    this.restTestClient.get().uri("/greeting")  // GETリクエストを /greeting に送信
        .exchange()                              // リクエストを実行
        .expectStatus().isOk()                   // HTTPステータス200(OK)を期待
        .expectBody()                            // レスポンスボディを検証
        .jsonPath("$.content").isEqualTo("Hello, World!");  // JSONのcontentフィールドを検証
        // $.content は JSONPath記法。$ はルート要素、.content はcontentプロパティを指す
  }

  /*
   * テスト2: name パラメータを指定した場合、指定した名前入りの挨拶が返ることを確認
   * GET /greeting?name=Spring Community → {"content": "Hello, Spring Community!"} を期待
   */
  @Test
  public void paramGreetingShouldReturnTailoredMessage() throws Exception {

    this.restTestClient.get()
        // URIビルダーを使ってクエリパラメータ付きのURLを組み立てる
        .uri(uri -> uri.path("/greeting").queryParam("name", "Spring Community").build())
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.content").isEqualTo("Hello, Spring Community!");
  }

}
