package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalFoodExceptionTest {

    @ParameterizedTest(name = "вид = \"{0}\"")
    @ValueSource(strings = {"Всеядное", "", "хищник"})
    @DisplayName("getFood бросает исключение для неизвестного вида")
    void testGetFoodThrowsExceptionForUnknownKind(String animalKind) {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
        assertEquals(
                "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage()
        );
    }
}
