package unittesting.business;

import unittesting.data.INumDataService;

public class AdditionUtil {

    INumDataService numDataService;

    public void setNumDataService(INumDataService numDataService1){
        numDataService = numDataService1;
    }

    public int sum(int[] data){
        int sum = 0;
        for(int value:data){
            sum += value;
        }
        return  sum;
    }

    public int sumUsingService(){
        int sum = 0;
        int[] data = numDataService.getIntArray();
        for(int value:data){
            sum += value;
        }
        return  sum;
    }
}
