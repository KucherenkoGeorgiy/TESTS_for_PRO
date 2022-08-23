package com.hillel.kucherenko.hw12test;

import com.hillel.kucherenko.hw12.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LinkedListTest {
    MyLinkedList<Integer> actualList;
    ArrayList<Integer> expectedList;

    @BeforeEach
    void initArrays() {
        actualList = new MyLinkedList<>();
        expectedList = new ArrayList<>();

        actualList.addElementToTheEndOfList(0);
        actualList.addElementToTheEndOfList(1);
        actualList.addElementToTheEndOfList(2);
        actualList.addElementToTheEndOfList(3);
        actualList.addElementToTheEndOfList(4);
        actualList.addElementToTheEndOfList(5);

        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(5);
    }


    @Test
    void whenTryingToAddElementToTheBeginning() {
        actualList.addElementToTheBeginningOfList(555);
        expectedList.add(0, 555);
        checkTheCase();
    }

    @Test
    void whenTryingToAddElementToTheEnd() {
        actualList.addElementToTheEndOfList(777);
        expectedList.add(777);
        checkTheCase();
    }

    @Test
    void whenTryingToAddElementByIndex() {
        actualList.addElementByIndex(123, 3);
        expectedList.add(3, 123);
        checkTheCase();
    }

    @Test
    void whenTryingToDeleteElementByIndex() {
        actualList.deleteElementByIndex(3);
        expectedList.remove(3);
        checkTheCase();
    }

    @Test
    void whenTryingToDeleteFirstElement() {
        actualList.deleteFirstElement();
        expectedList.remove(0);
        checkTheCase();
    }

    @Test
    void whenTryingToDeleteLastElement() {
        actualList.deleteLastElement();
        expectedList.remove(expectedList.size() - 1);
        checkTheCase();
    }

    @Test
    void whenTryToGetLengthOfList() {
        Assertions.assertEquals(expectedList.size(), actualList.getLength());
    }

    @Test
    void whenCheckIfIsEmpty() {
        Assertions.assertFalse(actualList.isEmptyList());
        while (actualList.getLength() != 0) {
            actualList.deleteLastElement();
        }
        Assertions.assertTrue(actualList.isEmptyList());
    }

    @Test
    void whenTryingToDeleteAllElementsInLoop() {
        while (actualList.getLength() != 0) {
            actualList.deleteFirstElement();
        }
        Assertions.assertTrue(actualList.isEmptyList());
    }

    @Test
    void whenInitFromArray() {
        Integer[] tempArray = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>(tempArray);
        ArrayList<Integer> tempArrayList = new ArrayList<>(Arrays.asList(tempArray));

        Assertions.assertEquals(tempArrayList.toString(), myLinkedList.toString());
    }

    @Test
    void whenTryingToInitEmptyList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        ArrayList<String> myArrayList = new ArrayList<>();
        Assertions.assertEquals(myArrayList.toString(), myLinkedList.toString());
    }

    @Test
    void whenTestingInverseOrSwap() {
        Collections.swap(expectedList, 2, 4);
        actualList.inverseElements(2, 4);
        checkTheCase();
    }

    private void checkTheCase() {
        Assertions.assertEquals(expectedList.toString(), actualList.toString());
    }
}
