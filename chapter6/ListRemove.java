package chapter6;

import java.util.ArrayList;

public class ListRemove extends Target {
    public ListRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    // remove items from beginning of list
    @Override
    public int method(int[] indicesOrnums) {
        int result = 0;
        ArrayList<Integer> smallerList = new ArrayList<>(list);
        
        for (int i = 0; i < indicesOrnums.length; i++) {
            if (!smallerList.isEmpty()) {
                smallerList.remove(0);
                result++;
            }
        }
        
        return result;
    }
}
