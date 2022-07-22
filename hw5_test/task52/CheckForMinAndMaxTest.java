package com.hillel.kucherenko.hw5_test.task52;

import com.hillel.kucherenko.hw5.task52.CheckForMinAndMax;
import com.hillel.kucherenko.hw5.task52.ResultOfMinMaxSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class CheckForMinAndMaxTest {

    @ParameterizedTest
    @MethodSource("provideInputData")
    void whenLookingForMinAndMaxValuesOfArrayThenReceiveThem1(int[] usersArray, int minValue, int minIndex,
                                                              int maxValue, int maxIndex) {
        CheckForMinAndMax checkForMinAndMax = new CheckForMinAndMax(usersArray);
        ResultOfMinMaxSearch resultOfMinSearch = checkForMinAndMax.findMinValue();
        ResultOfMinMaxSearch resultOfMaxSearch = checkForMinAndMax.findMaxValue();

        Assertions.assertEquals(minValue, resultOfMinSearch.valueOfResult);
        Assertions.assertEquals(minIndex, resultOfMinSearch.numberOfResult);

        Assertions.assertEquals(maxValue, resultOfMaxSearch.valueOfResult);
        Assertions.assertEquals(maxIndex, resultOfMaxSearch.numberOfResult);

    }

    private static Stream<Arguments> provideInputData() {
        return Stream.of(
                Arguments.of(new int[]{111, 22, 433, 333333, 123, 1}, 1, 1, 333333, 6),
                Arguments.of(new int[]{4, 255552, 433, 54, 123, 1}, 1, 1, 255552, 6),
                Arguments.of(new int[]{111, 22, 4344443, 333333, 123, 10, 2}, 2, 1, 4344443, 7)
        );

    }

    @Test
    void whenLookingForMinAndMaxValuesOfArrayThenReceiveThem() {
        CheckForMinAndMax checkForMinAndMax = new CheckForMinAndMax(new int[]{111, 22, 4, 333333});
        ResultOfMinMaxSearch resultOfMinSearch = checkForMinAndMax.findMinValue();
        ResultOfMinMaxSearch resultOfMaxSearch = checkForMinAndMax.findMaxValue();

        Assertions.assertEquals(4, resultOfMinSearch.valueOfResult);
        Assertions.assertEquals(1, resultOfMinSearch.numberOfResult);

        Assertions.assertEquals(333333, resultOfMaxSearch.valueOfResult);
        Assertions.assertEquals(6, resultOfMaxSearch.numberOfResult);

    }

}
