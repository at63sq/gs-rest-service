package com.example.restservice

/*
 * Greeting.kt - 挨拶（あいさつ）のデータを表すクラス（Kotlin版）
 *
 * 【解説】
 * Kotlinの「data class（データクラス）」は、Javaのrecordに相当する機能です。
 * データを保持するためのクラスを簡潔に定義できます。
 *
 * data classを使うと、以下のメソッドが自動生成されます：
 *   - toString()  : オブジェクトの内容を文字列として表示
 *   - equals()    : 2つのオブジェクトが同じ内容かを比較
 *   - hashCode()  : ハッシュ値を計算（HashMapなどで使用）
 *   - copy()      : オブジェクトのコピーを作成
 *
 * val = 変更不可（イミュータブル）な変数。一度値を設定したら変更できない。
 *   - id      : 挨拶の一意な識別番号（Long型 = 大きな整数）
 *   - content : 挨拶の本文（String型 = 文字列）
 *
 * REST APIのレスポンスとして、このオブジェクトがJSON形式に自動変換されます。
 */
data class Greeting(val id: Long, val content: String)
