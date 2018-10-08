package babysitter;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BabysitterTest {

    @Test
    void calculateCharge_invalid_input_throws_exception() {
        boolean errorThrown = false;
        try {
            Babysitter.calculateCharge(6, 5, 10);
        } catch (InvalidInputException e) {
            errorThrown = true;
        }
        assertTrue(errorThrown);
    }

    @Test
    void calculateCharge_valid_input_does_not_throw_exception() {
        boolean errorThrown = false;
        try {
            Babysitter.calculateCharge(5, 6, 10);
        } catch (InvalidInputException e) {
            errorThrown = true;
        }
        assertFalse(errorThrown);
    }
}