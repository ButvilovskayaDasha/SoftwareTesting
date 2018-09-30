import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assume.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class TriangleTest {

    private Triangle tr;
    private double a;
    private double b;
    private double c;
    private boolean expected;

    public TriangleTest(double a, double b, double c, boolean expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Before
    public void setup() {
        tr = new Triangle();
    }


    @Test
    public void assertTrueTest() {
        assertTrue(tr.isExist(5, 9, 9));
    }

    @Test
    public void assertNotNullTest() {
        assertNotNull(tr);
    }

    @Test
    public void assertFalseTest() {
        assertFalse(tr.isExist(5, 1, 9));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {5, 7, 3, true},
                {4, 3, 2, true},
                {5, -8, 9, false},
                {9, 6, -3, false},
                {5, 9, 0, false},
                {1, 9, 15, false}
        });
    }

    @Test
    public void parametersTest() {
        System.out.println("Running test for:" + a + " " + b + " " + c + ", expected = " + expected);
        assertEquals(expected, tr.isExist(a, b, c));
    }

    @Test
    public void assertSameTest() {
        assertSame(true, tr.isExist(5, 9, 9));
    }

    @Test
    public void assertEqualsTest() {
        assertEquals(true, tr.isExist((int) 5f, 9, 9));
    }

    @Test
    public void failTest() {
        if (tr == null) {
            fail("tr should not be null");
        }
    }

    @Test
    public void assumeTrueTest() {
        assumeTrue(tr.isExist(5, 9, 9));
    }

    @Test
    public void assumeFalseTest() {
        assumeFalse(tr.isExist(5, 9, 3));
    }

    @Test
    public void assertNotEqualsTest() {
        assertNotEquals(true, tr.isExist(5, 9, 3));
    }

    @After
    public void tearDown() {
        tr = null;
    }
}