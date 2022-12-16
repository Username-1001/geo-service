package ru.netology.sender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    @Test
    void send_with_russian_ip() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        Location location = new Location(null, Country.RUSSIA, null, 0);
        String expected =  "Добро пожаловать";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.any()))
                .thenReturn(location);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(expected);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, new LocalizationServiceImpl());

        assertEquals(expected, messageSender.send(headers));
    }

    @Test
    void send_with_american_ip() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        Location location = new Location(null, Country.USA, null, 0);
        String expected =  "Welcome";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.any()))
                .thenReturn(location);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(expected);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, new LocalizationServiceImpl());

        assertEquals(expected, messageSender.send(headers));
    }
}