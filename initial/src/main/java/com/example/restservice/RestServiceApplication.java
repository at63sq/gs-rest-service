package com.example.restservice;

// SpringApplication: Spring Bootアプリケーションを起動するためのクラス
import org.springframework.boot.SpringApplication;
// SpringBootApplication: Spring Bootの自動設定を有効にするアノテーション
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * RestServiceApplication.java - アプリケーションのエントリーポイント（起動点）
 *
 * 【解説】
 * これはSpring Bootアプリケーションの「初期状態（initial）」です。
 * まだREST APIのエンドポイント（Greeting, GreetingController）は実装されていません。
 * complete/ ディレクトリに完成版があります。
 *
 * @SpringBootApplication は、以下の3つのアノテーションを1つにまとめたものです：
 *   1. @Configuration      : このクラスがBean（部品）の定義を含むことを示す
 *   2. @EnableAutoConfiguration : Spring Bootが自動的に設定を行う
 *   3. @ComponentScan      : このパッケージ以下のクラスを自動検出・登録する
 *
 * main() メソッドがJavaプログラムのエントリーポイント（最初に実行される場所）です。
 * SpringApplication.run() を呼ぶことで、組み込みWebサーバーが起動します。
 */
@SpringBootApplication
public class RestServiceApplication {

  // Javaプログラムのエントリーポイント
  public static void main(String[] args) {
    // Spring Bootアプリケーションを起動
    SpringApplication.run(RestServiceApplication.class, args);
  }

}
