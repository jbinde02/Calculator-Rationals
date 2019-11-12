
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatrixTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatrixTest
{
    /**
     * Default constructor for test class MatrixTest
     */
    public MatrixTest()
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
    public void maticiesEqual()
    {
        Matrix matrix1 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Matrix matrix2 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        assertEquals(true, matrix1.equals(matrix2));
    }

    @Test
    public void addMatrices()
    {
        Matrix matrix1 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Matrix matrix2 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Matrix matrix3 = matrix1.addMatrix(matrix2);
        assertEquals(new Rational(2,2), matrix3.getElement(0,0));
        assertEquals(new Rational(2,2), matrix3.getElement(0,1));
        assertEquals(new Rational(2,2), matrix3.getElement(1,0));
        assertEquals(new Rational(2,2), matrix3.getElement(1,1));
    }

    @Test
    public void subtractMatrices()
    {
        Matrix matrix1 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Matrix matrix2 = new Matrix(new Rational(1,3), new Rational(1,4), new Rational(1,5), new Rational(1,6));
        Matrix matrix3 = matrix1.subtractMatrix(matrix2);
        assertEquals(new Rational(1,6), matrix3.getElement(0,0));
        assertEquals(new Rational(2,8), matrix3.getElement(0,1));
        assertEquals(new Rational(3,10), matrix3.getElement(1,0));
        assertEquals(new Rational(4,12), matrix3.getElement(1,1));
    }

    @Test
    public void scalarMatrix()
    {
        Matrix matrix1 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Rational rational1 = new Rational(1,5);
        Matrix matrix2 = matrix1.timesRational(rational1);
        assertEquals(new Rational(1,10), matrix2.getElement(0,0));
        assertEquals(new Rational(1,10), matrix2.getElement(0,1));
        assertEquals(new Rational(1,10), matrix2.getElement(1,0));
        assertEquals(new Rational(1,10), matrix2.getElement(1,1));
    }
    
        @Test
    public void multiplyMatrices()
    {
        Matrix matrix1 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Matrix matrix2 = new Matrix(new Rational(1,2), new Rational(1,2), new Rational(1,2), new Rational(1,2));
        Matrix matrix3 = matrix1.multiplyMatrix(matrix2);
        assertEquals(new Rational(2,4), matrix3.getElement(0,0));
        assertEquals(new Rational(2,4), matrix3.getElement(0,1));
        assertEquals(new Rational(2,4), matrix3.getElement(1,0));
        assertEquals(new Rational(2,4), matrix3.getElement(1,1));
    }
}

