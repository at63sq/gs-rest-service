package com.example.restservice;

// JUnit 5のテスト用アノテーション
import org.junit.jupiter.api.Test;

// テスト時にSpringアプリケーション全体を起動するアノテーション
import org.springframework.boot.test.context.SpringBootTest;

/*
 * RestServiceApplicationTests.java - アプリケーション起動テスト
 *
 * 【解説】
 * このテストクラスは、Spring Bootアプリケーションが正常に起動できるかを確認します。
 * contextLoads() メソッドは中身が空ですが、@SpringBootTest により
 * Springのアプリケーションコンテキスト（設定・Bean全体）が正しくロードされることを検証します。
 *
 * もしアプリケーションの設定にエラーがあれば、このテストが失敗します。
 * 「スモークテスト」とも呼ばれ、最低限の動作確認を行うテストです。
 */
@SpringBootTest
public class RestServiceApplicationTests {

  // アプリケーションコンテキストが正常にロードされるかを確認するテスト
  // メソッド内が空 = 例外が発生しなければテスト成功
  @Test
  public void contextLoads() {
  }

}
