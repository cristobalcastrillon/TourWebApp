package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationWebSiteIsNotValid;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationWebsiteURL extends StringValueObject {
    private LocationWebsiteURL() {
    }
    public LocationWebsiteURL(String webSiteUrl) {
        validate(webSiteUrl);
        this.value = webSiteUrl;
    }

    private void validate(String webSiteUrl) {
        // Validar que el URL sea una URL válida
        if (!webSiteUrl.startsWith("http://") && !webSiteUrl.startsWith("https://")) {
            throw new LocationWebSiteIsNotValid("The URL must start with http:// or https://");
        } else if (webSiteUrl.length() > 255) {
            throw new LocationWebSiteIsNotValid("The URL must be less than 255 characters");
        }
    }
}