package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineKittensTest {

    @ParameterizedTest(name = "количество = {0}")
    @ValueSource(ints = {0, 1, 3})
    @DisplayName("getKittens(int) возвращает переданное количество")
    void testGetKittensReturnsPassedCount(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
