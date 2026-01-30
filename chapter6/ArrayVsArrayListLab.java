package chapter6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {

    public static void main(String[] args) throws IOException {
       /* long start = System.nanoTime();
        System.out.println("hello, world");
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("println: " + elapsed + "ns");
        start = System.nanoTime();
        arrayTest(30_000);
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("arrayTest: " + elapsed + "ns"); */

        int arr[] = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random();
        int indices[] = new int[100_000];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = r.nextInt(arr.length);
        }

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));
        Target tests[] = new Target[8];
        double testAverages[] = new double[8];

        tests[0] = new ArrayRandom(arr, new ArrayList<>(list), "array,random_access");
        tests[1] = new ListRandom(arr, new ArrayList<>(list), "arraylist, random_access");
        tests[2] = new ArrayAppend(arr, new ArrayList<>(list), "array,append");
        tests[3] = new ListAppend(arr, new ArrayList<>(list), "arraylist,append");
        tests[4] = new ArrayInsert(arr, new ArrayList<>(list), "array,insert");
        tests[5] = new ListInsert(arr, new ArrayList<>(list), "arraylist,insert");
        tests[6] = new ArrayRemove(arr, new ArrayList<>(list), "array,remove");
        tests[7] = new ListRemove(arr, new ArrayList<>(list), "arraylist,remove");

        for (int i = 0; i < tests.length; i++) {
            Target target = tests[i];
            if (target != null) {
                testAverages[i] = target.runTests(indices);
                target.writeResults(fileOut);
            }
        }

        fileOut.close();
        
        // Print console summary
        System.out.println("Operation: random_access array avg: " + 
            String.format("%.2f", tests[0].getAverageMs()) + 
            " ms arraylist avg: " + 
            String.format("%.2f", tests[1].getAverageMs()) + 
            " ms winner: " + 
            (tests[0].getAverageMs() < tests[1].getAverageMs() ? "array" : "arraylist"));
            
        System.out.println("Operation: append array avg: " + 
            String.format("%.2f", tests[2].getAverageMs()) + 
            " ms arraylist avg: " + 
            String.format("%.2f", tests[3].getAverageMs()) + 
            " ms winner: " + 
            (tests[2].getAverageMs() < tests[3].getAverageMs() ? "array" : "arraylist"));
            
        System.out.println("Operation: insert array avg: " + 
            String.format("%.2f", tests[4].getAverageMs()) + 
            " ms arraylist avg: " + 
            String.format("%.2f", tests[5].getAverageMs()) + 
            " ms winner: " + 
            (tests[4].getAverageMs() < tests[5].getAverageMs() ? "array" : "arraylist"));
            
        System.out.println("Operation: remove array avg: " + 
            String.format("%.2f", tests[6].getAverageMs()) + 
            " ms arraylist avg: " + 
            String.format("%.2f", tests[7].getAverageMs()) + 
            " ms winner: " + 
            (tests[6].getAverageMs() < tests[7].getAverageMs() ? "array" : "arraylist"));
    }
}
