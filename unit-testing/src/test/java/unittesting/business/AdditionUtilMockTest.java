package unittesting.business;

import org.junit.Before;
import org.junit.Test;
import unittesting.data.INumDataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@AutoConfigureMockMvc
public class AdditionUtilMockTest {

    AdditionUtil additionUtil = new AdditionUtil();
    INumDataService numDataServiceMock = mock(INumDataService.class);

    @Before
    public void before(){
        additionUtil.setNumDataService(numDataServiceMock);
    }

    @Test
    public void sum() {
        when(numDataServiceMock.getIntArray()).thenReturn(new int[] {1,4,5});

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