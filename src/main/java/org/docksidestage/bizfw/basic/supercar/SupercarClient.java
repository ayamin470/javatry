/*
 * Copyright 2019-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.supercar;

import java.util.ArrayList;
import java.util.Collection;

import org.docksidestage.bizfw.basic.supercar.SupercarManufacturer.Supercar;

/**
 * The client(顧客) of supercar.
 * @author jflute
 */

/**
 * ここがおそらく全てのはじまり
 * ディーラーを「作成」してディーラーに注文する感じ
 */
public class SupercarClient {

    private final Collection<Supercar> orderedCustomCarCollection = new ArrayList<>();

    public Supercar buySupercar() {
        Supercar orderedCustomCar;

        try {
            SupercarDealer dealer = createDealer();
            String clientRequirement = prepareClientRequirement();

            // ここで例外が発生する可能性があるので、try-catchで囲む
            orderedCustomCar = dealer.orderSupercar(clientRequirement);
            orderedCustomCarCollection.add(orderedCustomCar);
            return orderedCustomCar;

        } catch (SupercarManufactureException e) {
            throw new SupercarClientException("スーパーカーの購入に失敗しました。顧客の要件: '" + prepareClientRequirement() + "'。詳細: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            throw new SupercarClientException(
                    "スーパーカーの購入中に予期せぬシステムエラーが発生しました。", e);
        }
    }

    private String prepareClientRequirement() {

        return "steering wheel is like sea and has kawaii face";
    }

    protected SupercarDealer createDealer() {
        return new SupercarDealer();
    }
}
