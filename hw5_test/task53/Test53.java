package com.hillel.kucherenko.hw5_test.task53;

import com.hillel.kucherenko.hw5.task53.CheckingForRepeats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Test53 {

    @Test
    void whenSearchesForRepeatedCharsInNumericReturnBoolean1 (){
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(12345);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertEquals(false, hasRepeats);

    }

    @Test
    void whenSearchesForRepeatedCharsInNumericReturnBoolean2 (){
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(122345);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertEquals(true, hasRepeats);

    }

    @Test
    void whenSearchesForRepeatedCharsInNumericReturnBoolean3 (){
        CheckingForRepeats checkingForRepeats = new CheckingForRepeats(1234445);
        boolean hasRepeats = checkingForRepeats.checkForRepeats();
        Assertions.assertEquals(true, hasRepeats);

    }

}
