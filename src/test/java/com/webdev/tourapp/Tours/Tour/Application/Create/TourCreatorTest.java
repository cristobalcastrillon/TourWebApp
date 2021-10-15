package com.webdev.tourapp.Tours.Tour.Application.Create;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TourCreatorTest {
    Tour tour;
    TourRepository repository;
    ArrayList<Location> locationList = new ArrayList<>();

    @BeforeEach
    void setup(){
        this.locationList.add(new Location("7cce613b-2b79-4a90-90bd-daf02c94f376",
                "Sagrada Familia",
                "41°24′13″N 2°10′27″E",
                "El Templo Expiatorio de la Sagrada Familia (en catalán, Temple Expiatori de la Sagrada Família), conocido simplemente como la Sagrada Familia, es una basílica católica de Barcelona (España), diseñada por el arquitecto Antoni Gaudí.",
                "Templo",
                "https://sagradafamilia.org/historia-del-temple",
                26.0));
        this.locationList.add(new Location("714af06b-f455-43f9-9a1d-9bef6e20ef02",
                "Casa Batlló",
                "41°23'17.99″ N 2°09'32.40″ E",
                "La Casa Batlló es un edificio obra del arquitecto Antoni Gaudí, máximo representante del modernismo catalán.",
                "Bien de Interés Cultural",
                "https://www.casabatllo.es/",
                35.0));

        this.tour = new Tour(new TourID("d79d401a-d61a-42bc-81ec-0b5e0edb2e52"),
                new TourName("Tour Gaudí en Barcelona"),
                new TourPrice(200.0),
                this.locationList);

        this.repository = mock(TourRepository.class);
    }

    @Test
    void should_create_tour(){

        TourCreator creator = new TourCreator(repository);

        creator.execute("d79d401a-d61a-42bc-81ec-0b5e0edb2e52", "Tour Gaudí en Barcelona", 200.0, this.locationList);

        verify(repository, atLeastOnce()).save(this.tour);
    }

}
