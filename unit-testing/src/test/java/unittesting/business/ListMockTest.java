package unittesting.business;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
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

    // Say suppose you want to fin out the specific value passed on a mock
    @Test
    public void argumentCapture(){

        // System Under Test
        mock.add("SomeString");

        // Verify that the get method id called on the mock
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        // Test the value that was captured
        Assert.assertEquals("SomeString", captor.getValue());
    }


    // Say suppose you want to fin out the specific value passed on a mock
    @Test
    public void argumentCaptureMultiple(){

        // System Under Test
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verify that the get method id called on the mock
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        // Test the value that was captured
        Assert.assertEquals("SomeString1", captor.getAllValues().get(0));
        Assert.assertEquals("SomeString2", captor.getAllValues().get(1));
    }

    @Test
    public void mockingBase(){

        ArrayList arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0

        System.out.println(arrayListMock.add("Test"));
        System.out.println(arrayListMock.add("Test2"));
        System.out.println("After 2 additions to the mock: " + arrayListMock.size()); // 0

        when(arrayListMock.size()).thenReturn(5);
        System.out.println("After manual set to 5: " + arrayListMock.size()); // 5

        // arrayListMock.add("Test2");
    }

    @Test
    public void spyingBase(){

        // Spy retains original behavior of teh class is retained
        ArrayList arrayListMock = spy(ArrayList.class);
        System.out.println(arrayListMock.add("Test0"));

        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size()); // 1

        System.out.println(arrayListMock.add("Test1"));
        System.out.println(arrayListMock.add("Test2"));
        System.out.println("After 2 more additions to the mock: " + arrayListMock.size()); // 3

        // You are taking control here
        when(arrayListMock.size()).thenReturn(5);
        System.out.println("After manual set to 5: " + arrayListMock.size()); // 5

        System.out.println(arrayListMock.add("Test4"));
        System.out.println("After manual set to 5 and ADD another item: " + arrayListMock.size()); // 5

        verify(arrayListMock).add("Test4");
    }
}