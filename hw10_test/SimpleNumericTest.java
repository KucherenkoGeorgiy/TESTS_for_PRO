package com.hillel.kucherenko.hw10_test;

import com.hillel.kucherenko.hw10.ArrayOfSimple;
import com.hillel.kucherenko.hw10.MicroArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimpleNumericTest {
    final static int minValue = 5;
    final static int maxValue = 1000;
    final static int arraysQuantity = 50;
    final static ArrayOfSimple arrayOfSimple = new ArrayOfSimple(minValue, maxValue, arraysQuantity);

    static {
        arrayOfSimple.makeThreads();
    }


    @Test
    void checkIfArrayConsistsOfSubarraysCorrectly() {
        int[] actualFinalArray = arrayOfSimple.getFinalArray();
        int[] currentMicroArray = new int[]{};
        int counterForCurrentMicroArray = 0;
        boolean hasProblem = false;

        for (int i = 0; i < actualFinalArray.length; i++) {
            if (currentMicroArray.length == 0) {
                currentMicroArray = searchForNeededMicroArray(arrayOfSimple, actualFinalArray[i]);
                counterForCurrentMicroArray = 0;
            }
            System.out.println("now we compare: " + actualFinalArray[i] + " and "
                    + currentMicroArray[counterForCurrentMicroArray]);
            if (actualFinalArray[i] != currentMicroArray[counterForCurrentMicroArray]) {
                hasProblem = true;
                break;
            }
            if (counterForCurrentMicroArray == currentMicroArray.length - 1) {
                currentMicroArray = new int[]{};
            }
            counterForCurrentMicroArray++;
        }
        Assertions.assertFalse(hasProblem);
    }

    private int[] searchForNeededMicroArray(ArrayOfSimple arrayOfSimple, int i) {
        MicroArray[] tempMicroarrays = arrayOfSimple.getMyMicroArrays();
        int[] tempRes = new int[]{};
        int tempValue;

        for (int j = 0; j < tempMicroarrays.length; j++) {
            if (tempMicroarrays[j].getRes().length > 0) {
                tempValue = tempMicroarrays[j].getRes()[0];
                if (tempValue == i) {
                    tempRes = tempMicroarrays[j].getRes();
                }
            }
        }
        System.out.println("Searching for microarray with " + i);
        System.out.println("We found needed microarray:");
        System.out.println(Arrays.toString(tempRes));
        return tempRes;
    }

    @Test
    void whenTryToGetSimplesReceiveCorrectValues() {
        int[] expectedArray = new int[]{};
        int[] actualResult = Arrays.copyOf(arrayOfSimple.getFinalArray(), arrayOfSimple.getFinalArray().length);
        boolean isSimple;

        Arrays.sort(actualResult);

        for (int i = minValue; i < maxValue; i++) {
            isSimple = true;
            for (int j = 2; j <= (i / 2); j++) {
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
