package com.webdev.tourapp.Cities.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class CityID extends CustomUUID {

    public CityID(String id) {
        super(id);
    }

    public CityID() {
    }
}

// Pendiente consensuar como van a ser los ID para las ciudades