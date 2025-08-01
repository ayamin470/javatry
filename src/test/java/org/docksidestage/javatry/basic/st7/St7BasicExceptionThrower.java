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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jflute
 */
public class St7BasicExceptionThrower {

    private static final Logger logger = LoggerFactory.getLogger(St7BasicExceptionThrower.class);

    public void land() {
        logger.debug("park");
        showbase();
    }

    private void showbase() {
        logger.debug("stage");
        oneman();
    }

    private void oneman() {
        logger.debug("show");
        throw new IllegalStateException("oneman at showbase");  //例外を伝える
    }
}
