package babysitter;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BabysitterTest {

    // Test case 1
    @Test
    void calculateCharge_case_1() throws InvalidInputException {
        int expected = 144, result;
        result = Babysitter.calculateCharge(5, 4, 11);
        assertEquals(expected, result);
    }

    // Test case 2
    @Test
    void calculateCharge_case_2() throws InvalidInputException {
        int expected = 148, result;
        result = Babysitter.calculateCharge(5, 4, 12);
        assertEquals(expected, result);
    }

    // Test case 3
    @Test
    void calculateCharge_case_3() throws InvalidInputException {
        int expected = 148, result;
        result = Babysitter.calculateCharge(5, 4, 1);
        assertEquals(expected, result);
    }

    // Test case 4
    @Test
    void calculateCharge_case_4() throws InvalidInputException {
        int expected = 64, result;
        result = Babysitter.calculateCharge(12, 4, 11);
        assertEquals(expected, result);
    }

    // Test case 5
    @Test
    void calculateCharge_case_5() throws InvalidInputException {
        int expected = 48, result;
        result = Babysitter.calculateCharge(1, 4, 2);
        assertEquals(expected, result);
    }

    // Test case 6
    @Test
    void calculateCharge_case_6() throws InvalidInputException {
        int expected = 48, result;
        result = Babysitter.calculateCharge(1, 4, 11);
        assertEquals(expected, result);
    }

    // Test case 7
    @Test
    void calculateCharge_case_7() throws InvalidInputException {
        int expected = 48, result;
        result = Babysitter.calculateCharge(5, 10, 7);
        assertEquals(expected, result);
    }

    // Test case 8
    @Test
    void calculateCharge_case_8() throws InvalidInputException {
        int expected = 36, result;
        result = Babysitter.calculateCharge(5, 8, 11);
        assertEquals(expected, result);
    }

    // Test case 9
    @Test
    void calculateCharge_case_9() throws InvalidInputException {
        int expected = 20, result;
        result = Babysitter.calculateCharge(10, 12, 11);
        assertEquals(expected, result);
    }

    // Test case 10
    @Test
    void calculateCharge_case_10() throws InvalidInputException {
        int expected = 8, result;
        result = Babysitter.calculateCharge(9, 10, 8);
        assertEquals(expected, result);
    }

    // Test case 11
    @Test
    void calculateCharge_case_11() throws InvalidInputException {
        int expected = 16, result;
        result = Babysitter.calculateCharge(9, 11, 9);
        assertEquals(expected, result);
    }

    // Test case 12
    @Test
    void calculateCharge_case_12() throws InvalidInputException {
        int expected = 56, result;
        result = Babysitter.calculateCharge(9, 2, 9);
        assertEquals(expected, result);
    }

    // Test case 13
    @Test
    void calculateCharge_case_13() throws InvalidInputException {
        int expected = 56, result;
        result = Babysitter.calculateCharge(9, 2, 7);
        assertEquals(expected, result);
    }

    // Test case 14
    @Test
    void calculateCharge_case_14() throws InvalidInputException {
        int expected = 24, result;
        result = Babysitter.calculateCharge(9, 12, 9);
        assertEquals(expected, result);
    }

    // Test case 15
    @Test
    void calculateCharge_case_15() throws InvalidInputException {
        int expected = 24, result;
        result = Babysitter.calculateCharge(9, 11, 11);
        assertEquals(expected, result);
    }

    // Test case 16
    @Test
    void calculateCharge_case_16() throws InvalidInputException {
        int expected = 68, result;
        result = Babysitter.calculateCharge(9, 2, 2);
        assertEquals(expected, result);
    }

    // Test case 17
    @Test
    void calculateCharge_case_17() throws InvalidInputException {
        int expected = 32, result;
        result = Babysitter.calculateCharge(12, 2, 12);
        assertEquals(expected, result);
    }

    // Test case 18
    @Test
    void calculateCharge_case_18() throws InvalidInputException {
        int expected = 36, result;
        result = Babysitter.calculateCharge(9, 12, 12);
        assertEquals(expected, result);
    }

    // Test case f1
    @Test
    void calculateCharge_case_f1() {
        boolean errorThrown = false;
        try {
            Babysitter.calculateCharge(9, 9, 9);
        } catch (InvalidInputException e) {
            errorThrown = true;
        }
        assertTrue(errorThrown);
    }

    // Test case f2
    @Test
    void calculateCharge_invalid_input_throws_exception() {
        boolean errorThrown = false;
        try {
            Babysitter.calculateCharge(9, 6, 8);
        } catch (InvalidInputException e) {
            errorThrown = true;
        }
        assertTrue(errorThrown);
    }

    // Test case 1
    @Test
    void calculateCharge_valid_input_does_not_throw_exception() {
        boolean errorThrown = false;
        try {
            Babysitter.calculateCharge(5, 4, 11);
        } catch (InvalidInputException e) {
            errorThrown = true;
        }
        assertFalse(errorThrown);
    }
}