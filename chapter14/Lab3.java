package chapter14;

import java.util.ArrayList;
import java.util.List;
import json.*;

public class Lab3 {
    public static void main(String[] args) throws Exception {
        ArrayList<BikeDataRecord> records = new ArrayList<>();
        ArrayList<BikeDataRecord> records1 = BikeDataReader.parse("json/day1.json");
        ArrayList<BikeDataRecord> records2 = BikeDataReader.parse("json/day2.json");
        ArrayList<BikeDataRecord> records3 = BikeDataReader.parse("json/day3.json");
        ArrayList<BikeDataRecord> records4 = BikeDataReader.parse("json/day4.json");
        records.addAll(records1);
        records.addAll(records2);
        records.addAll(records3);
        records.addAll(records4);

        
        System.out.println("Question 1 Results:");
        
        // Sort all records by power (sortCriteria = 7) using Merge Sort
        BikeDataRecord.sortCriteria = 7; 
        List<BikeDataRecord> sortedByPower = Sorting.mergeSort(records);
        
        //get the last 15 for highest power
        List<BikeDataRecord> top15Power = sortedByPower.subList(sortedByPower.size() - 15, sortedByPower.size());
        
        // Reverse to display highest power first
        java.util.Collections.reverse(top15Power);
        
        System.out.println("Top 15 Riding Records with Highest Power Output:");
        int rank = 1;
        for (BikeDataRecord record : top15Power) {
            System.out.printf("%2d. Power: %4dW | Speed: %5.2f m/s | HR: %3d bpm | Timestamp: %d%n", 
                rank, record.getPow(), record.getSpeed(), record.getHeartrate(), record.getTimestamp());
            rank++;
        }

        
        System.out.println("Question 2 Results:");
        
        // Sort by timestamp for binary search (sortCriteria = 0)
        BikeDataRecord.sortCriteria = 0; // 0 = timestamp
        List<BikeDataRecord> sortedByTime = Sorting.mergeSort(records);
        
        // Define 12-2 PM time windows (2 hours = 7200 seconds) for each day
        long[][] timeWindows = {
            {1141920754L, 1141927954L},                           // Day 1: 12-2 PM window
            {1141920754L + 86400, 1141927954L + 86400},          // Day 2: 12-2 PM window
            {1141920754L + 172800, 1141927954L + 172800},        // Day 3: 12-2 PM window
            {1141920754L + 259200, 1141927954L + 259200}         // Day 4: 12-2 PM window
        };
        String[] dayNames = {"Day 1", "Day 2", "Day 3", "Day 4"};
        
        int totalHighHRCount = 0;
        for (int d = 0; d < timeWindows.length; d++) {
            //find all records in the 12-2 PM time window
            ArrayList<BikeDataRecord> windowRecords = Searching.binarySearch(
                (ArrayList<BikeDataRecord>) sortedByTime,
                timeWindows[d][0],
                timeWindows[d][1]
            );
            
           //heart rate > 110 bpm
            List<BikeDataRecord> highHRRecords = windowRecords.stream()
                .filter(r -> r.getHeartrate() > 110)
                .toList();
            
            System.out.printf("%s: %d records with HR > 110 bpm%n", dayNames[d], highHRRecords.size());
            totalHighHRCount += highHRRecords.size();
        }
        
        System.out.printf("\nTotal across all 4 days: %d times HR exceeded 110 bpm%n", totalHighHRCount);

    }
}
