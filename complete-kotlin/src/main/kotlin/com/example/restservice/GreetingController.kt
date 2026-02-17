package com.example.restservice

// AtomicLong: スレッドセーフ（複数の処理が同時に安全にアクセス可能）な長整数カウンター
import java.util.concurrent.atomic.AtomicLong

// Spring Frameworkのアノテーションをインポート
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/*
 * GreetingController.kt - REST APIのエンドポイント（受付窓口）を定義するクラス（Kotlin版）
 *
 * 【解説】
 * Kotlinでは、クラスの外にトップレベルの定数を定義できます。
 * private const val は、このファイル内でのみ使えるコンパイル時定数です。
 * Javaの private static final String に相当します。
 *
 * @RestController: このクラスがREST APIのコントローラーであることをSpringに伝えます。
 * メソッドの戻り値がJSON形式に自動変換されてHTTPレスポンスとして返されます。
 */

// テンプレート文字列: %s が実際の名前に置き換わる
// private = このファイル内でのみアクセス可能
// const = コンパイル時に値が確定する定数
private const val template = "Hello, %s!"

@RestController
class GreetingController {

  // カウンター: リクエストごとに1ずつ増加し、各挨拶に一意のIDを付与
  private val counter = AtomicLong()

  /*
   * @GetMapping("/greeting"): HTTP GETリクエストで "/greeting" にアクセスされたとき呼ばれる
   *
   * Kotlinでは、関数本体が1行の式で表せる場合、"=" を使って簡潔に書けます。
   * これを「式本体関数（expression body function）」と呼びます。
   *
   * @RequestParam name: String = "World"
   *   → URLクエリパラメータ "name" を受け取る。省略時はデフォルト値 "World"。
   *   → Kotlinではデフォルト引数を言語レベルでサポートしている。
   *
   * 例: http://localhost:8080/greeting?name=Taro → "Hello, Taro!"
   */
  @GetMapping("/greeting")
  fun greeting(@RequestParam name: String = "World") =
    Greeting(counter.incrementAndGet(), template.format(name))
    // counter.incrementAndGet(): カウンターを1増やしてその値を返す
    // template.format(name): "%s" を name に置換した文字列を生成

}
