package ru.netology.geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    GeoService geoService;

    @BeforeEach
    void setUp() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void byIp() {
        String russianIp = "172.168.10.20";
        String americanIp = "96.68.21.11";
        Country expectedRussia = Country.RUSSIA;
        Country expectedUSA = Country.USA;

        assertEquals(expectedRussia, geoService.byIp(russianIp).getCountry());
        assertEquals(expectedUSA, geoService.byIp(americanIp).getCountry());
        assertEquals(null, geoService.byIp(GeoServiceImpl.LOCALHOST).getCountry());
    }
}