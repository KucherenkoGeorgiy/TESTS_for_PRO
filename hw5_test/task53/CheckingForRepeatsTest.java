package com.hillel.kucherenko.hw5_test.task53;

import com.hillel.kucherenko.hw5.task53.CheckingForRepeats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CheckingForRepeatsTest {

    @ParameterizedTest
    @ValueSource(ints = {123, 456, 890})
    void whenSearchesForRepeatedCharsInNumericReturnBoolean4(int number) {
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(number);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertFalse(hasRepeats);
    }


    @Test
    void whenSearchesForRepeatedCharsInNumericReturnBoolean1() {
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(12345);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertFalse(hasRepeats);
    }

    @Test
    void whenSearchesForRepeatedCharsInNumericReturnBoolean2() {
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(122345);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertTrue(hasRepeats);
    }

    @Test
    void whenSearchesForRepeatedCharsInNumericReturnBoolean3() {
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(1234445);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertTrue(hasRepeats);
    }
}
