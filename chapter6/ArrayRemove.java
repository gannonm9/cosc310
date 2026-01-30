package chapter6;

import java.util.ArrayList;

public class ArrayRemove extends Target{
    public ArrayRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    // remove items from beginning of arr
    @Override
    public int method(int[] indicesOrnums) {
        int result = 0; 
        int smallerArr[] = new int[arr.length - 20_000];

        for (int i = 0; i < smallerArr.length; i++){
            smallerArr[i] = arr[i + 20_000];
            result ++;
        
        }
        return result;
    }
}
