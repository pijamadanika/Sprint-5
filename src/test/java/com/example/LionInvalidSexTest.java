package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LionInvalidSexTest {

    @ParameterizedTest(name = "пол = \"{0}\"")
    @ValueSource(strings = {"Неизвестно", "", "самец"})
    @DisplayName("Конструктор бросает исключение при недопустимом поле")
    void testConstructorThrowsExceptionForInvalidSex(String sex) {
        FelineInterface feline = Mockito.mock(FelineInterface.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, feline));
        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }
}
