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
package org.docksidestage.javatry.basic.st6.dbms;

/**
 * @author jflute
 * @author ayamin
 */
public class St6MySql extends DetabaseSet {

    // done offsetを導出するロジックがMySQLとPostgreSQLで冗長なのでどうにかしたいですね by jflute (2025/07/10)
    @Override
    protected String doBuildPagingSqlPart(int pageSize, int offset) {
        return "limit " + offset + ", " + pageSize;
    }
}

// TODO [memo] ayamin @Overrideはなるべくつけよう！
//  タイプミスによって違うメソッドだと認識されたり、スーパークラスのシグネチャが変更された時にコンパイルエラーを出してくれたり、便利
// done ayamin [ふぉろー] そうですね。もう付けられるところは全部付けるみたいな感覚になっています by jflute (2025/07/10)
// Java5から導入された機能なので、Javaさんが互換性のために必須にはできなかったんですよね。
