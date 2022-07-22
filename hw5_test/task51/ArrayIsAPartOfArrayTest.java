package com.hillel.kucherenko.hw5_test.task51;

import com.hillel.kucherenko.hw5.task51.ArrayIsAPartOfArray;
import com.hillel.kucherenko.hw5.task51.ResultOfComparing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class ArrayIsAPartOfArrayTest {

    @ParameterizedTest
    @MethodSource("provideInputData")
    void whenCheckIfArrayIsAPartOfAnotherArrayThenReturnTrueOrFalseX(int[] bigArray,
                                                                     int[] smallArray, boolean expected) {

        ArrayIsAPartOfArray arrayIsAPartOfArray = new ArrayIsAPartOfArray(bigArray, smallArray);
        ResultOfComparing resultOfComparing = arrayIsAPartOfArray.compareArrays();
        Assertions.assertEquals(expected, resultOfComparing.isCorrect);
    }

    private static Stream<Arguments> provideInputData() {
        return Stream.of(
                Arguments.of(new int[]{2, 12, 3, 6, 12, 313, 4, 23, 77}, new int[]{6, 12, 313}, true),
                Arguments.of(new int[]{2, 12, 3, 6, 12, 313, 4, 23, 77}, new int[]{6, 122, 313}, false),
                Arguments.of(new int[]{2, 12, 3, 6, 12, 313, 4, 23, 77}, new int[]{313, 4}, true)
        );
    }

    @Test
    void whenCheckIfArrayIsAPartOfAnotherArrayThenReturnTrueOrFalse() {
        ArrayIsAPartOfArray arrayIsAPartOfArray = new ArrayIsAPartOfArray(new int[]{2, 12, 3, 6, 12, 313, 4, 23, 77},
                                                                            new int[]{6, 12, 313});

        ResultOfComparing resultOfComparing = arrayIsAPartOfArray.compareArrays();
        Assertions.assertTrue(resultOfComparing.isCorrect);
    }
}
