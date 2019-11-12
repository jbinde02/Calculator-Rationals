
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RationalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RationalTest
{
    /**
     * Default constructor for test class RationalTest
     */
    public RationalTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void doubleValueThreeFourthEqualsPointSevenFive()
    {
        Rational rational1 = new Rational(3, 4);
        assertEquals(0.75, rational1.doubleValue(), 0);
    }

    @Test
    public void floatValueThreeFourthsEqualsPointSeventyFive()
    {
        Rational rational1 = new Rational(3, 4);
        assertEquals(0.75, rational1.floatValue(), 0);
    }

    @Test
    public void intValueFiveFourthEqualsOne()
    {
        Rational rational1 = new Rational(5, 4);
        assertEquals(1, rational1.intValue(), 0);
    }

    @Test
    public void longValueFiveSixthEqualsZero()
    {
        Rational rational1 = new Rational(5, 6);
        assertEquals(0, rational1.longValue(), 0);
    }

    @Test
    public void addRationalCorrect()
    {
        Rational rational1 = new Rational(5, 6);
        Rational rational2 = new Rational(4, 5);
        Rational rational3 = rational1.addRational(rational2);
        assertEquals(49, rational3.getNumerator());
        assertEquals(30, rational3.getDenominator());
    }

    @Test
    public void subtractRationalCorrect()
    {
        Rational rational1 = new Rational(5, 6);
        Rational rational2 = new Rational(4, 5);
        Rational rational3 = rational1.subtractRational(rational2);
        assertEquals(1, rational3.getNumerator());
        assertEquals(30, rational3.getDenominator());
    }

    @Test
    public void multiplyRationalCorrect()
    {
        Rational rational1 = new Rational(5, 6);
        Rational rational2 = new Rational(4, 5);
        Rational rational3 = rational1.multiplyRational(rational2);
        assertEquals(20, rational3.getNumerator());
        assertEquals(30, rational3.getDenominator());
    }

    @Test
    public void divideRationalCorrect()
    {
        Rational rational1 = new Rational(5, 6);
        Rational rational2 = new Rational(2, 3);
        Rational rational3 = rational1.divideRational(rational2);
        assertEquals(15, rational3.getNumerator());
        assertEquals(12, rational3.getDenominator());
    }

    @Test
    public void greatestCommonFactorOfSixTwentySeventhsEqualsThree()
    {
        Rational rational1 = new Rational(6, 27);
        assertEquals(3, rational1.greatestCommonFactor());
    }

    @Test
    public void simplifyEighteenOverTwentyToNineOverTen()
    {
        Rational rational1 = new Rational(18, 20);
        Rational rational2 = rational1.simplifyRational();
        assertEquals(9, rational2.getNumerator());
        assertEquals(10, rational2.getDenominator());
    }


    @Test
    public void toStringNineTenths()
    {
        Rational rational1 = new Rational(9, 10);
        assertEquals("9/10", rational1.toString());
    }

    @Test
    public void isEqualsSimplifiedOneFraction()
    {
        Rational rational1 = new Rational(5, 10);
        Rational rational2 = new Rational(1, 2);
        Rational rational3 = rational1.simplifyRational();
        assertEquals(true, rational2.equals(rational3));
    }

    @Test
    public void noNegativeDenominator()
    {
        Rational rational1 = new Rational(5, -8);
        assertEquals(-5, rational1.getNumerator());
        assertEquals(8, rational1.getDenominator());
    }
}






