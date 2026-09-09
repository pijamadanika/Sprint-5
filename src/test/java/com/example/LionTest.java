package com.example;

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
class LionTest {

    @Mock
    private FelineInterface feline;

    @Test
    @DisplayName("getKittens возвращает значение из Feline")
    void testGetKittensReturnsFelineValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);

        int actual = lion.getKittens();

        assertEquals(3, actual);
        verify(feline).getKittens();
    }

    @Test
    @DisplayName("getFood возвращает еду хищника из Feline")
    void testGetFoodReturnsPredatorFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        verify(feline).getFood("Хищник");
    }
}
