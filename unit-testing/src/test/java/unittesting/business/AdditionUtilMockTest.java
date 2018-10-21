package unittesting.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import unittesting.data.INumDataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class AdditionUtilMockTest {

    @InjectMocks
    AdditionUtil additionUtil = new AdditionUtil();

    @Mock
    INumDataService numDataServiceMock;

    @Test
    public void sum() {
        when(numDataServiceMock.getIntArray()).thenReturn(new int[] {1,4,5});
        assertEquals(10, additionUtil.sumUsingService());
    }

    @Test
    public void sum_empty() {
        when(numDataServiceMock.getIntArray()).thenReturn(new int[]{});
        assertEquals(0, additionUtil.sumUsingService());
    }

    @Test
    public void sum_one_value() {
        when(numDataServiceMock.getIntArray()).thenReturn(new int[] {5});
        assertEquals(5, additionUtil.sumUsingService());
    }
}