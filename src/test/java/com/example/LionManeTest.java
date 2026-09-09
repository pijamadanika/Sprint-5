package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LionManeTest {

    @ParameterizedTest(name = "пол {0} → грива {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    @DisplayName("Наличие гривы зависит от пола")
    void testDoesHaveManeReturnsExpectedValue(String sex, boolean hasMane) throws Exception {
        FelineInterface feline = Mockito.mock(FelineInterface.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }
}
