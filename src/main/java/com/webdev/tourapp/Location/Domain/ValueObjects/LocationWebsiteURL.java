package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationWebsiteURL extends StringValueObject {
    private LocationWebsiteURL() {
    }
    public LocationWebsiteURL(String webSiteUrl) {
        validate(webSiteUrl);
        this.value = webSiteUrl;
    }

    private void validate(String webSiteUrl) {
    }
}