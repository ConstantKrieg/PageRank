package algorithms;

import org.junit.Test;

import static algorithms.NumberUtils.floor;
import static algorithms.NumberUtils.round;
import static org.junit.Assert.assertEquals;

public class NumberUtilsTest {

    @Test
    public void testFloor()
    {
        double x = 2.453;
        int xi = floor(x);

        assertEquals(xi, 2);
    }

    @Test
    public void testRound()
    {
        double x = 2.453;
        double roundedX = round(x, 1);

        assertEquals(2.5, roundedX, 0);
    }
}
