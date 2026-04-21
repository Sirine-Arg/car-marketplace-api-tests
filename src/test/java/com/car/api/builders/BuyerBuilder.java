package com.car.api.builders;

import com.car.api.pojoModels.Buyer;
import com.car.api.pojoModels.Preferences;

import java.util.List;

public class BuyerBuilder {
    public static Buyer defaultBuyer() {

        Preferences preferences = new Preferences();
        preferences.preferredBrands = List.of("Tesla", "Audi");
        preferences.maxBudget = 55000;
        preferences.fuelType = "ELECTRIC";

        Buyer buyer = new Buyer();
        buyer.buyerId = "buyer-123";
        buyer.registeredAt = "2026-03-28T15:42:08Z";
        buyer.firstName = "Sophie";
        buyer.lastName = "Martin";
        buyer.email = "sophie.martin@example.com";
        buyer.phone = "+33754981236";
        buyer.preferences = preferences;

        return buyer;
    }
}
