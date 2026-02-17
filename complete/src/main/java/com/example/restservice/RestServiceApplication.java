package com.example.restservice;

// SpringApplication: Spring Bootアプリケーションを起動するためのクラス
import org.springframework.boot.SpringApplication;
// SpringBootApplication: Spring Bootの自動設定を有効にするアノテーション
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * RestServiceApplication.java - アプリケーションのエントリーポイント（起動点）
 *
 * 【解説】
 * @SpringBootApplication は、以下の3つのアノテーションを1つにまとめたものです：
 *   1. @Configuration      : このクラスがBean（部品）の定義を含むことを示す
 *   2. @EnableAutoConfiguration : Spring Bootが依存ライブラリに基づいて
 *                                  自動的に設定を行うことを有効にする
 *   3. @ComponentScan      : このパッケージ以下のクラスを自動的に検出・登録する
 *                            （例: @RestController が付いたクラスを見つける）
 *
 * Javaプログラムは main() メソッドから実行が始まります。
 * SpringApplication.run() を呼ぶことで、組み込みWebサーバー（Tomcat）が起動し、
 * HTTPリクエストを受け付ける準備が整います。
 * デフォルトではポート8080で起動します（http://localhost:8080）。
 */
@SpringBootApplication
public class RestServiceApplication {

  // Javaプログラムのエントリーポイント（最初に実行されるメソッド）
  // args: コマンドライン引数（起動時にオプションを渡すために使用）
  public static void main(String[] args) {
    // Spring Bootアプリケーションを起動する
    // 第1引数: メインクラス（このクラス自身）
    // 第2引数: コマンドライン引数をそのまま渡す
    SpringApplication.run(RestServiceApplication.class, args);
  }

}
