package com.dd.eraktkendrabackend.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    /**
     * Method under test: {@link Calculator#add(int, int)}
     */
    @Test
    void testAdd() {
        assertEquals(4, (new Calculator()).add(2, 2));
        assertEquals(2, (new Calculator()).add(1, 1));
        assertEquals(5, (new Calculator()).add(3, 2));
        assertEquals(3, (new Calculator()).add(1, 2));
    }

    /**
     * Method under test: {@link Calculator#subtract(int, int)}
     */
    @Test
    void testSubtract() {
        assertEquals(0, (new Calculator()).subtract(1, 1));
        assertEquals(2, (new Calculator()).subtract(3, 1));
        assertEquals(0, (new Calculator()).subtract(0, 1));
        assertEquals(99999, (new Calculator()).subtract(100000, 1));
    }

    /**
     * Method under test: {@link Calculator#multiply(int, int)}
     */
    @Test
    void testMultiply() {
        assertEquals(1, (new Calculator()).multiply(1, 1));
        assertEquals(3, (new Calculator()).multiply(3, 1));
        assertEquals(0, (new Calculator()).multiply(0, 1));
        assertEquals(100000, (new Calculator()).multiply(100000, 1));
    }

    /**
     * Method under test: {@link Calculator#divide(int, int)}
     */
    @Test
    void testDivide() {
        assertEquals(1, (new Calculator()).divide(1, 1));
        assertEquals(0, (new Calculator()).divide(1, 0));
        assertEquals(3, (new Calculator()).divide(3, 1));
        assertEquals(100000, (new Calculator()).divide(100000, 1));
    }

    /**
     * Method under test: {@link Calculator#isSumAllowed(int)}
     */
    @Test
    void testIsSumAllowed() {
        assertTrue((new Calculator()).isSumAllowed(10));
    }
}

