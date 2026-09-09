package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("getSound возвращает «Мяу»")
    void testGetSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    @DisplayName("getFood возвращает еду хищника из Feline")
    void testGetFoodReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
        verify(feline).eatMeat();
    }
}
