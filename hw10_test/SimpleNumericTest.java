package com.hillel.kucherenko.hw10_test;

import com.hillel.kucherenko.hw10.ArrayOfSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class SimpleNumericTest {

    @Test
    void whenTryToGetSimplesReceiveCorrectValues() {
        ArrayOfSimple arrayOfSimple = new ArrayOfSimple(5, 100, 20);
        int[] expectedArray = new int[]{};
        boolean isSimple;

        arrayOfSimple.makeThreads();
        try {
            System.out.println("===========================================");
            System.out.println("Please wait for 3 seconds..");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }
        int[] actualResult = arrayOfSimple.getFinalArray();
        Arrays.sort(actualResult);

        for (int i = 5; i < 100; i++) {
            isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                expectedArray = pushElementToArray(expectedArray, i);
            }
        }
        Assertions.assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualResult));
    }

    private int[] pushElementToArray(int[] expectedArray, int i) {
        int[] tempArray = new int[]{};
        if (expectedArray == null) {
            expectedArray = new int[]{i};
        } else {
            tempArray = new int[expectedArray.length + 1];
            for (int j = 0; j < expectedArray.length; j++) {
                tempArray[j] = expectedArray[j];
            }
            tempArray[tempArray.length - 1] = i;
        }
        expectedArray = tempArray;
        return expectedArray;
    }
}
