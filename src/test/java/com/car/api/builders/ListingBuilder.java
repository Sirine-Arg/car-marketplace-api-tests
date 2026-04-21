package com.car.api.builders;

import com.car.api.pojoModels.Listing;
import com.car.api.pojoModels.Price;
import com.car.api.pojoModels.Vehicle;

public class ListingBuilder {

    public static Listing defaultListing() {

        Vehicle vehicle = new Vehicle();
        vehicle.vin = "1HGCM82633A123456";
        vehicle.brand = "BMW";
        vehicle.model = "X5";
        vehicle.year = 2022;
        vehicle.mileage = 45000;
        vehicle.fuelType = "PETROL";
        vehicle.transmission = "AUTOMATIC";

        Price price = new Price();
        price.amount = 32000;
        price.currency = "EUR";

        Listing listing = new Listing();
        listing.listingId = "a7c91f2d-4b55";
        listing.status = "ACTIVE";
        listing.createdAt = "2026-04-17T10:15:30Z";
        listing.sellerId = "seller-123";
        listing.vehicle = vehicle;
        listing.price = price;

        return listing;
    }
}
