package ru.netology.i18n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void locale() {
        String expectedRussian = "Добро пожаловать";
        String expectedDefault = "Welcome";

        assertEquals(expectedRussian, localizationService.locale(Country.RUSSIA));
        assertEquals(expectedDefault, localizationService.locale(Country.BRAZIL));
        assertEquals(expectedDefault, localizationService.locale(Country.GERMANY));
        assertEquals(expectedDefault, localizationService.locale(Country.GERMANY));
    }
}