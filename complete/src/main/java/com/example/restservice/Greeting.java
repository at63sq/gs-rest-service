package com.example.restservice;

/*
 * Greeting.java - 挨拶（あいさつ）のデータを表すクラス
 *
 * 【解説】
 * このクラスは Java 16 以降で使える「record（レコード）」という機能を使っています。
 * recordは「データを保持するだけのクラス」を簡潔に定義するための仕組みです。
 *
 * 通常のクラスでは、フィールド宣言、コンストラクタ、getter、toString()、
 * equals()、hashCode() などを自分で書く必要がありますが、
 * recordを使うとこれらが自動的に生成されます。
 *
 * このrecordは以下の2つのフィールドを持ちます：
 *   - id      : 挨拶の一意な識別番号（long型 = 大きな整数）
 *   - content : 挨拶の本文（String型 = 文字列）
 *
 * REST APIのレスポンス（応答）として、このオブジェクトが
 * 自動的にJSON形式（例: {"id":1, "content":"Hello, World!"}）に変換されます。
 * この変換はSpring Bootの内部にあるJacksonというライブラリが行います。
 */
public record Greeting(long id, String content) { }
