package unittesting.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionUtilTest {

    @Test
    public void sum() {
        AdditionUtil additionUtil = new AdditionUtil();

        int result = additionUtil.sum(new int[] {1,4,5});
        int expected = 10;

        assertEquals(expected, result);
    }

    @Test
    public void sum_empty() {
        AdditionUtil additionUtil = new AdditionUtil();

        int result = additionUtil.sum(new int[] {});
        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    public void sum_one_value() {
        AdditionUtil additionUtil = new AdditionUtil();

        int result = additionUtil.sum(new int[] {5});
        int expected = 5;

        assertEquals(expected, result);
    }

}