package e.kaari.passwordvalidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 *
 *
 *
 */
@RunWith(Parameterized.class)
public class PWStrengthTest {
    private String inputPW;
    private Integer expectedResult;
    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }
    //each set of paramters used as an argument below
    public PWStrengthTest(String inputPW, Integer expectedResult) {
        this.inputPW = inputPW;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Collection passwords(){
        return Arrays.asList(new Object[][] {
            //input, then expected result
            { "password", 1 },
            { "1234567", 2 },
            { "1526374949928764673", 3 },
            { "##%$%&^*&$(*%($&#$", 3 },
            { "onlylowercase", 2 },
            { "ONLYUPPPERCASE", 2 },
            { "CONTAINSbothoftheCASES", 3 },
            { "UPEPRWEPR7163553672", 3 },
            { "!@#$%67890", 4 },
            { "aG00Dp4%%w3RD", 5 }
        });
    }//end parameters
    @Test
    public void testPWStrengthTest() {
        assertEquals(expectedResult, validator.validate(inputPW));
    }
}