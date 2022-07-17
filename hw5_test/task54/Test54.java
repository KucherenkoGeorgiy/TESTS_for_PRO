package com.hillel.kucherenko.hw5_test.task54;

import com.hillel.kucherenko.hw5.task54.BuildingMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test54 {

    @Test
    void whenInputIntThenBuildsMatrix1() {
        BuildingMatrix buildingMatrix = new BuildingMatrix(5);
        String actualResult = buildingMatrix.buildMatrix();
        String expectedResult = "1\t2\t3\n"
                            + "4\t5\t0\n"
                            + "0\t0\t0\n";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void whenInputIntThenBuildsMatrix2() {
        BuildingMatrix buildingMatrix = new BuildingMatrix(12);
        String actualResult = buildingMatrix.buildMatrix();
        String expectedResult = "1\t2\t3\t4\n"
                            + "5\t6\t7\t8\n"
                            + "9\t10\t11\t12\n"
                            + "0\t0\t0\t0\n";
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
