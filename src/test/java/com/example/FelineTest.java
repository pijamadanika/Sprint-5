package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    @DisplayName("eatMeat возвращает рацион хищника")
    void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    @DisplayName("getFamily возвращает «Кошачьи»")
    void testGetFamilyReturnsCats() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    @DisplayName("getKittens без аргумента возвращает 1")
    void testGetKittensWithoutCountReturnsOne() {
        assertEquals(1, feline.getKittens());
    }
}
