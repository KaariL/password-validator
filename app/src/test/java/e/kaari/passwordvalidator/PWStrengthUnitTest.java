package e.kaari.passwordvalidator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *
 *
 */
public class PWStrengthUnitTest {
    private Validator one;
    private Validator two;
    private Validator three;
    
    @Before
    public void setUp(){
        one = new Validator("password");
        two = new Validator("1234567");
        three = new Validator("isnotpwand8charaslong");
    }
    @Test
    public void passwordStrengthTest() {
        int result1 = one.validate();
        int result2 = two.validate();
        int result3 = three.validate();
        int expected = 1;
        int expectedAll = 2;
        assertTrue(expected==result1);
        assertTrue(expected==result2);
        assertTrue(expectedAll==result3);
    }
}