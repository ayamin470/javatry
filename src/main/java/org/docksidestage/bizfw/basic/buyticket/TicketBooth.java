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
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author ayamin
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;
    private static final int FOUR_DAY_PRICE = 22400;
    private static final int NIGHT_ONLY_TWO_DAY_PRICE = 7400;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase

    private final ClockProvider clockProvider;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth(ClockProvider clockProvider) {
        // TODO ayamin インスタンス変数と同じ初期化しているので、どっちか不要 by jflute (2025/07/25)
        this.quantity = MAX_QUANTITY;
        this.salesProceeds = null;
        this.clockProvider = clockProvider;
    }

    public TicketBooth() {
        this(new SystemClockProvider());
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, ONE_DAY_PRICE, 1, false);
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, TWO_DAY_PRICE, 2, false);
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, FOUR_DAY_PRICE, 4, false);
    }

    public TicketBuyResult buyNightOnlyTwoDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, NIGHT_ONLY_TWO_DAY_PRICE, 2, true);
    }

    // ===================================================================================
    //                                                                       doBuyPassport
    //                                                                          ==========
    private TicketBuyResult doBuyPassport(Integer handedMoney, int price, int ticketValidDays, boolean nightOnly) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out: quantity=" + quantity);
        }
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney + " < " + price);
        }
        --quantity;

        if (salesProceeds != null) {
            salesProceeds = salesProceeds + price;
        } else {
            salesProceeds = price;
        }

        Ticket ticket = new Ticket(price, ticketValidDays, nightOnly, clockProvider);
        int change = handedMoney - price;
        return new TicketBuyResult(ticket, change);
    }

    public static class TicketSoldOutException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
