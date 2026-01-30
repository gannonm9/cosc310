package chapter6;
import java.util.ArrayList;

public class ListInsert extends Target {

    public ListInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    // insert new items at beginning of list
    @Override
    public int method(int[] indicesOrnums) {
        int sum = 0;
        ArrayList<Integer> largerList = new ArrayList<>();
        
        // Add new items at beginning
        for (int i = 0; i < indicesOrnums.length; i++) {
            largerList.add(indicesOrnums[i]);
        }
        
        // Add original items and calculate sum
        for (int i = 0; i < list.size(); i++) {
            largerList.add(list.get(i));
            sum += list.get(i);
        }
        
        return sum;
    }
}
