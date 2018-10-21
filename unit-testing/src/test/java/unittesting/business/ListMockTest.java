package unittesting.business;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

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

    // If a specific item is called on the list
    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("0 element");
        Assert.assertEquals("0 element", mock.get(0));

        // This will fail as all other elements are null -> the "default". Only "0" is mapped
        // --> Assert.assertEquals("0 element", mock.get(1));
        Assert.assertEquals(null, mock.get(1));
        Assert.assertEquals(null, mock.get(10));
    }

    // If any item is called on the list
    @Test
    public void returnWithGenericParameters() {
        // anyInt() acts as an argument matcher

        when(mock.get(anyInt())).thenReturn("Any element");
        Assert.assertEquals("Any element", mock.get(0));
        Assert.assertEquals("Any element", mock.get(1));
        Assert.assertEquals("Any element", mock.get(100));
    }

    @Test
    public void verificationBasics(){

        // System Under Test
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // Verify that the get method id called on the mock
        verify(mock).get(0);

        // Verify that it was called only 2 time or at most 2 times
        verify(mock, times(2)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());

        // See that get 3 is never called
        verify(mock, never()).get(3);
    }

}