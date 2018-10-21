package unittesting.business;

import org.junit.Test;
import unittesting.data.INumDataService;

import static org.junit.Assert.assertEquals;

class NumDataServiceStub implements INumDataService {

    int[] data;

    public NumDataServiceStub(int [] data) {
        this.data = data;
    }

    @Override
    public int[] getIntArray() {
        return data;
    }
}

public class AdditionUtilStubTest {

    @Test
    public void sum() {
        AdditionUtil additionUtil = new AdditionUtil();
        additionUtil.setNumDataService(new NumDataServiceStub(new int[] {1,4,5}));

        int result = additionUtil.sumUsingService();
        int expected = 10;

        assertEquals(expected, result);
    }

    @Test
    public void sum_empty() {
        AdditionUtil additionUtil = new AdditionUtil();
        additionUtil.setNumDataService(new NumDataServiceStub(new int[] {}));

        int result = additionUtil.sumUsingService();
        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    public void sum_one_value() {
        AdditionUtil additionUtil = new AdditionUtil();
        additionUtil.setNumDataService(new NumDataServiceStub(new int[] {5}));

        int result = additionUtil.sumUsingService();
        int expected = 5;

        assertEquals(expected, result);
    }
    
}