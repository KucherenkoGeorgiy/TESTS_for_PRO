package com.hillel.kucherenko.hw5_test.task51;

import com.hillel.kucherenko.hw5.task51.ArrayIsAPartOfArray;
import com.hillel.kucherenko.hw5.task51.ResultOfComparing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test51 {

    @Test
    void whenCheckIfArrayIsAPartOfAnotherArrayThenReturnTrueOrFalse(){
        ArrayIsAPartOfArray arrayIsAPartOfArray = new ArrayIsAPartOfArray(new int[]{2, 12, 3, 6, 12, 313, 4, 23, 77}, new int[]{6, 12, 313});
        ResultOfComparing resultOfComparing = arrayIsAPartOfArray.compareArrays();
        Assertions.assertEquals(true, resultOfComparing.isCorrect);
    }
}
