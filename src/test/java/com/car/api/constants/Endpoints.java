package com.car.api.constants;

public class Endpoints {

    // Base paths
    public static final String CREATE_LISTING = "/CreateListing";
    public static final String CREATE_BUYER = "/CreateBuyer";
    public static final String CREATE_TRANSACTION = "/CreateTransaction";
    public static final String GET_ALL_LISTINGS = "/GetAllListings";
    public static final String GET_ALL_TRANSACTIONS = "/GetAllTransactions";
    public static final String GET_ALL_BUYERS = "/GetAllBuyers";




    // Dynamic endpoints
    public static String getTransactionById(String id) {
        return CREATE_TRANSACTION + "/" + id;
    }

    public static String deleteTransaction(String id) {
        return CREATE_TRANSACTION + "/" + id;
    }
}