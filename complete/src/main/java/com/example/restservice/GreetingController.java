package com.example.restservice;

// AtomicLong: スレッドセーフ（複数の処理が同時にアクセスしても安全）な
//             長整数型カウンター。Webサーバーは複数リクエストを同時に処理するため必要。
import java.util.concurrent.atomic.AtomicLong;

// Spring Frameworkのアノテーション（注釈）をインポート
// アノテーションとは「@」で始まる特別な印で、クラスやメソッドに追加情報を付与するもの
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * GreetingController.java - REST APIのエンドポイント（受付窓口）を定義するクラス
 *
 * 【解説】
 * @RestController アノテーションは、このクラスが「REST APIのコントローラー」
 * であることをSpringに伝えます。
 * コントローラーとは、クライアント（ブラウザやアプリ）からのHTTPリクエストを
 * 受け取り、適切なレスポンス（応答）を返す役割を持つクラスです。
 *
 * @RestControllerを付けると、メソッドの戻り値が自動的にJSON形式に変換されて
 * HTTPレスポンスのボディ（本文）として返されます。
 */
@RestController
public class GreetingController {

  // テンプレート文字列: %s の部分が実際の名前に置き換わる
  // "Hello, %s!" → "Hello, World!" や "Hello, Taro!" のようになる
  // static final = クラス全体で共有される変更不可の定数
  private static final String template = "Hello, %s!";

  // カウンター: リクエストが来るたびに1ずつ増える。各挨拶に一意のIDを付与するため。
  // AtomicLongを使うことで、複数のリクエストが同時に来ても正しくカウントできる。
  private final AtomicLong counter = new AtomicLong();

  /*
   * @GetMapping("/greeting") は、HTTP GETリクエストで "/greeting" というURLに
   * アクセスされたときに、このメソッドが呼ばれることを意味します。
   *
   * 例: http://localhost:8080/greeting?name=Taro
   *
   * @RequestParam は、URLのクエリパラメータ（?name=Taro の部分）を
   * メソッドの引数として受け取るためのアノテーションです。
   * defaultValue = "World" は、パラメータが省略された場合のデフォルト値です。
   *
   * 戻り値のGreetingオブジェクトは、Springが自動的にJSON形式に変換して返します。
   */
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
    // counter.incrementAndGet() でカウンターを1増やし、その値をIDとして使用
    // template.formatted(name) で "%s" を name の値に置換
    return new Greeting(counter.incrementAndGet(), template.formatted(name));
  }
}
