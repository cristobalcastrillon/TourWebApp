package com.webdev.tourapp.Users.Guide.Domain.Ports;

import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.Guide;

import java.util.List;
import java.util.Optional;

public interface GuideRepository
{
    void save (Guide guide);
    void update (Guide guide);
    void delete (Guide guide);
    Optional<List<Guide>> all();
    Optional<Guide> findByID(GuideID id);
}