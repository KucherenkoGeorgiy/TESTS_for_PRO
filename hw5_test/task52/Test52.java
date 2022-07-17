package com.hillel.kucherenko.hw5_test.task52;

import com.hillel.kucherenko.hw5.task52.CheckForMinAndMax;
import com.hillel.kucherenko.hw5.task52.ResultOfMinMaxSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test52 {

    @Test
    void whenLookingForMinAndMaxValuesOfArrayThenReceiveThem(){
        CheckForMinAndMax checkForMinAndMax = new CheckForMinAndMax(new int[]{111, 22, 4, 333333});
        ResultOfMinMaxSearch resultOfMinSearch = checkForMinAndMax.findMinValue();
        ResultOfMinMaxSearch resultOfMaxSearch = checkForMinAndMax.findMaxValue();

        Assertions.assertEquals(1, resultOfMinSearch.valueOfResult);
        Assertions.assertEquals(2, resultOfMinSearch.numberOfResult);

        Assertions.assertEquals(6, resultOfMaxSearch.valueOfResult);
        Assertions.assertEquals(3, resultOfMaxSearch.numberOfResult);

    }

}
