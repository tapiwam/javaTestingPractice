package unittesting.business;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);

    @Test
    public void testBasic() {
        when(mock.size()).thenReturn(5);
        Assert.assertEquals(5, mock.size());
    }

    @Test
    public void testDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);

        // Use the first return
        Assert.assertEquals(5, mock.size());

        // The second time returns the second value
        Assert.assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("0 element");
        Assert.assertEquals("0 element", mock.get(0));

        // This will fail as all other elements are null -> the "default". Only "0" is mapped
        // --> Assert.assertEquals("0 element", mock.get(1));
    }



}