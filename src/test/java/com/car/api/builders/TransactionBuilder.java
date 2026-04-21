package com.car.api.builders;

import com.car.api.pojoModels.Transaction;

public class TransactionBuilder {

    public static Transaction defaultTransaction(String listingId, String buyerId) {

        Transaction t = new Transaction();
        t.transactionId = "tx-001";
        t.listingId = listingId;
        t.buyerId = buyerId;
        t.paymentMethod = "CREDIT_CARD";
        t.amount = 32000;
        t.currency = "EUR";
        t.status = "COMPLETED";
        t.purchaseDate = "2026-04-17T10:20:45Z";

        return t;
    }
}
