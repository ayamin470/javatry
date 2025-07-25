/*
 * Copyright 2019-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.basic;

import java.math.BigDecimal;

import org.docksidestage.unit.PlainTestCase;

// #1on1: よもやま話: 途切れ途切れの作業でも困らない工夫を (2025/07/25)
// #1on1: Live Templatesのimportのデモ: 繰り返す指を効率化する工夫を (2025/07/25)
/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author ayamin
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? =>　mystic8null:mai
    }
    /* 文字列に数値やnullを入れると自動的に文字列に変換される */

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic";
        String land = "oneman";
        sea = land;
        land = land + "'s dreams";
        log(sea); // your answer? => oneman
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        sea = land.add(new BigDecimal(1));
        sea.add(new BigDecimal(1));
        log(sea); // your answer? => 416
    }

    //  BigDecimalは新しいインスタンスを作るために、元の変数は置き換わらない
    //  sea.add(new BigDecimal(1));しても、seaの中身は+１されていない。sea(2)が作られて、それが+1されているイメージ

    /* sea.add(new BigDecimal(1));された結果は、どこにも参照されない */
    // done ayamin そのとおりです。BigDecimal の add() は自分自身を変えるわけではなく... by jflute (2025/07/01)
    // 変えたもの (足したもの) を新しく生み出して戻り値として戻します。
    // そういったクラス(オブジェクト)のことを、なんて呼ぶかご存知でしょうか？

    // done jflute by ayamin (2025/07/08)
    // イミュータブル (Immutable) オブジェクトだと思います
    // 今回はBigDecimalですが、ほかにもBigIntegerや、String クラス: concat(), substring(), replace() など、Stringイミュータブルです メソッドも
    // これらは一度作られた後は変更できないので、元のオブジェクトを変更するのではなく、新しいオブジェクトを生成してその結果を返します

    // done ayamin [へんじ] Goodです。ありがとうございます！1on1のときに少しだけ補足する予定です。 by jflute (2025/07/02)
    // ちなみに、todoに対するdoneですが、
    // ↓の「レビューのやり取り」の欄を参考にお願いします。
    // https://dbflute.seasar.org/ja/tutorial/handson/review/jflutereview.html#review
    // TODOにはこのように返事をすると言うこと。理解しました。次回から修正いたします
    // done ayamin 改めて、Slackでtodoのdoneについて補足していますので、Slackご覧ください by jflute (2025/07/07)

    // done jflute 1on1にて、immutableの補足をする (2025/07/08)
    // #1on1: 質問、BigDecimalだったら何でもできるから、最初からそうしてた方が汎用性が高いか？
    // 回答: 論理的にはその通りですが、BigDecimalはちょっと扱いづらいクラスなので、
    // かつ、めったに小数点が追加されることってないので、まあ現実はInteger/Long使っちゃいます。
    // #1on1: IntelliJでメソッド補完時にcontrol+Jでjavadoc表示
    // #1on1: javadocでimmutableと書いてあったり、add()のソースコードを読んでimmutableであることを知る
    // #1on1: immutableのバランス話

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => instanceBroadway
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 0
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => null
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bigband|1|null|magician
    }

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? =>
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => harbor416
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;

        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => harbor
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }

    // #1on1: インスタンスとは？のお話

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========

    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    // done ayamin 中括弧が左に下がっているのは、これは意図してやっていますか？ by jflute (2025/07/01)
    // フォーマットの一つのやり方なんですけど、あまりJavaだと中括弧が左に下げる方式は見ないので。

    //    DONE dbfluteさん
    //    意図してやっています
    //    何が入れ子構造になっているのかよく混乱してしまうため。レビューしにくくなってしまうようであれば、左下げをしないよう気をつけます。
    // done ayamin [へんじ] おっ、なるほど。見やすくするために工夫しようとしていること自体はとても素晴らしいです by jflute (2025/07/02)
    // 大昔から、(些細なことですけど) どっちスタイル？っていうのがありまして...
    //
    // Wikipediaの「字下げスタイル」を見ると...このページ初めてみたのですが、こんなにたくさん種類があるとは!?
    // https://ja.wikipedia.org/wiki/%E5%AD%97%E4%B8%8B%E3%81%92%E3%82%B9%E3%82%BF%E3%82%A4%E3%83%AB
    //
    // ayaminさんのこのケースは「オールマン」スタイルのようですね。
    // javatryデフォルトだと「K&R」スタイルに近いかもですね。
    //
    // 研修としては、ayaminさんの中での一貫性があるのであればOKという感じですね。
    // (ケースバイケースでマチマチだったりすると、読む人は見づらいと感じるかもしれません)
    // ここって現場に寄りますので、一番はこれから触るであろう現場のコードがどっちになってるか？
    // それにjavatryのうちから合わせた方が良いかもというのはありますので、
    // ぜひ現場の先輩に聞いてみてください(^^。
    // done jflute 1on1にて、字下げだけじゃなくフォーマット全体の話をする (2025/07/08)
    // #1on1 フォーマッターのお話。javaのデフォルトのフォーマットのお話。

    public class original extends PlainTestCase {
        private int piari;
        public void test_variable_writing() {
            String sea = "mystic";
            Integer land = null;
            log(sea + "," + land + "," + piari);
        }
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========

    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     *
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */

    public class VariableTest extends PlainTestCase {

        private Integer instanceCounter = 0;
        private String instanceMessage = "Hello";

        public void challenge() {
            Integer localCounter = 10;
            String localMessage = "World";

            modifyValues(localCounter, localMessage);

            // your answer? =>

            String result = instanceCounter + "-" + instanceMessage + "-" + localCounter + "-" + localMessage;
            log(result);
        }

        private void modifyValues(Integer counter, String message) {
            counter = counter + 5;
            message = message + " Java!";
            instanceCounter = instanceCounter + counter;
            instanceMessage = instanceMessage + message;
        }
    }

    /**
     インスタンス変数：
     ・クラスの定義内（メソッドの外）に記述される
     ・クラスから作られた各「インスタンス（オブジェクト）」ごとに、それぞれ固有の値を保持できる変数

     class Cake {
     String type;
     int price;
     String topping;
     }

     type,price,toppingそれぞれがインスタンス変数で、
     それぞれに"チョコレートケーキ","ショートケーキ","500""600"というように、インスタンスごとに別の値を入れられる
     */

}
