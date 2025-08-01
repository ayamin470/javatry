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
package org.docksidestage.javatry.basic.st7;

/**
 * @author jflute
 */
public class St7ConstructorChallengeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public St7ConstructorChallengeException(String msg) {
        super(msg);
    }
    public St7ConstructorChallengeException(String msg, Throwable cause) {
        super(msg, cause); // 親クラス(RuntimeException)の、メッセージと原因を受け取るコンストラクタを呼び出す
    }
}
