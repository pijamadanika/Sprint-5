package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    private Feline feline;

    private Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    @DisplayName("Возвращает список друзей: Марти, Глория и Мелман")
    void testGetFriendsReturnsMartyGloriaAndMelman() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    @DisplayName("Возвращает место обитания — Нью-Йоркский зоопарк")
    void testGetPlaceOfLivingReturnsNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    @DisplayName("getKittens возвращает 0 и не обращается к Feline")
    void testGetKittensReturnsZero() {
        assertEquals(0, alex.getKittens());
        verify(feline, never()).getKittens();
    }

    @Test
    @DisplayName("Конструктор создаёт самца — у Алекса есть грива")
    void testConstructorCreatesMaleLion() {
        assertTrue(alex.doesHaveMane());
    }
}
