package com.hillel.kucherenko.hw8_test;

import com.hillel.kucherenko.hw8.classesauto.Bus;
import com.hillel.kucherenko.hw8.classesauto.PassengerCar;
import com.hillel.kucherenko.hw8.classesauto.Transport;
import com.hillel.kucherenko.hw8.classesauto.Truck;
import com.hillel.kucherenko.hw8.classespark.Park;
import com.hillel.kucherenko.hw8.interfacepark.InterfaceTaxipark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.stream.Stream;

public class CarParkProcessorTest {

    static Transport[] transportsForTest = new Transport[]{
            new Bus(1992, "Ikarus", "ik155", 14300, 5.5, 115, 48),
            new PassengerCar(2020, "BMW", "x5", 33000, 6.3, 240, false),
            new PassengerCar(2020, "Skoda", "Fabia", 6000, 8.2, 160, true),
            new Bus(1995, "Ikarus", "ik200", 18000, 23, 130, 55),
            new Truck(2006, "MAN", "MAN100", 55000, 38, 162, 22000)
    };

    @Test
    void whenTrySortMethodMustReturnSortedArray() {
        Transport[] park = transportsForTest.clone();
        InterfaceTaxipark testTaxipark = new Park(park);
        testTaxipark.sortMyPark();
        Transport[] actualResultPark = testTaxipark.getMyPark();

        Transport[] expectedResultPark = new Transport[]{
                new Bus(1992, "Ikarus", "ik155", 14300, 5.5, 115, 48),
                new PassengerCar(2020, "BMW", "x5", 33000, 6.3, 240, false),
                new PassengerCar(2020, "Skoda", "Fabia", 6000, 8.2, 160, true),
                new Bus(1995, "Ikarus", "ik200", 18000, 23, 130, 55),
                new Truck(2006, "MAN", "MAN100", 55000, 38, 162, 22000)
        };

        Assertions.assertEquals(Arrays.toString(expectedResultPark), Arrays.toString(actualResultPark));
    }

    @ParameterizedTest
    @MethodSource("provideInputDataForTotalCostOfMyPark")
    void whenTryToGetTotalCostOfMyParReceiveTotalCost(Transport[] transports, int expectedTotalCost) {
        InterfaceTaxipark myPark = new Park(transports);
        int actualTotalCost = myPark.getTotalCostOfMyPark();

        Assertions.assertEquals(expectedTotalCost, actualTotalCost);
    }

    private static Stream<Arguments> provideInputDataForTotalCostOfMyPark() {
        return Stream.of(
                Arguments.of(transportsForTest, 126300),
                Arguments.of(new Transport[]{
                        new Bus(1992, "Ikarus", "ik155", 14300, 5.5, 115, 48),
                        new PassengerCar(2020, "BMW", "x5", 33000, 6.3, 240, false),
                        new Bus(1995, "Ikarus", "ik200", 18000, 23, 130, 55),
                        new Truck(2006, "MAN", "MAN100", 55000, 38, 162, 22000)
                }, 120300)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputDataForSearchingOfMinAndMaxSpeed")
    void whenTryToGetMinAndMaxSpeedOfParkThenReceiveIt(Transport[] transports,
                                                       int minSpeed, int maxSpeed, Transport[] expectedResultTransport) {
        InterfaceTaxipark myPark = new Park(transports);
        Transport[] actualResultTransport = myPark.searchByMinAndMaxSpeed(minSpeed, maxSpeed);

        Assertions.assertEquals(Arrays.toString(expectedResultTransport), Arrays.toString(actualResultTransport));

    }

    private static Stream<Arguments> provideInputDataForSearchingOfMinAndMaxSpeed() {
        return Stream.of(
                Arguments.of(transportsForTest, 109, 161, new Transport[]{
                        new Bus(1992, "Ikarus", "ik155", 14300, 5.5, 115, 48),
                        new PassengerCar(2020, "Skoda", "Fabia", 6000, 8.2, 160, true),
                        new Bus(1995, "Ikarus", "ik200", 18000, 23, 130, 55)
                }),
                Arguments.of(transportsForTest, 110, 120, new Transport[]{
                        new Bus(1992, "Ikarus", "ik155", 14300, 5.5, 115, 48),
                })
        );
    }
}
