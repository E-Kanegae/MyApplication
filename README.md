# MyApplication
 My Application to practice various functions
SpringBootの色々な機能を学ぶ・試すためのアプリ。無駄に技術を使っているので別に最適化されているわけではない。

## プロジェクト
1. `record-app`:メインのアプリ。幾つかのことを記録する機能を持つ。
  * 読書記録機能：読書記録を記録する。DBはMongDBの3.6系を利用している。`2`の`books-api`を`RestTemplate`で呼び出し、利用する。
2. `books-api`:書籍検索API（現時点ではGoogleBooksAPI）を呼び出して、情報を加工後RESTで返却するAPI。

## 主要ライブラリのバージョン
* Spring Boot: 2.2.2.RELEASE

## その他
