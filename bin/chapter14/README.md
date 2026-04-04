Problems Defined:
1. What were the top 15 riding records that had the top 15 power outputs across the four days of riding?
2. How many times did the heart rate exceed 110 BPM during the times of 12 - 2 PM.

Justification for sorting and searching algorithm:
I chose the Merge Sort as it sorts the full bike data set in time regardless of what the input order is. It also works well for the combined records of all 4 JSON data files. Although merge sort does have to allocate space, its fine as merge sort is extremely reliable so its not an issue. When it comes to the search, as its easy to search the timestamp list for what I was looking for, which in this case, was heart rate. 

The results:

Question 1 Results:
Top 15 Riding Records with Highest Power Output:
 1. Power:  705W | Speed: 10.63 m/s | HR: 107 bpm | Timestamp: 1142010515
 2. Power:  697W | Speed:  7.15 m/s | HR: 113 bpm | Timestamp: 1142015078
 3. Power:  685W | Speed:  9.97 m/s | HR: 107 bpm | Timestamp: 1142010514
 4. Power:  663W | Speed: 10.76 m/s | HR: 107 bpm | Timestamp: 1142010516
 5. Power:  654W | Speed:  5.38 m/s | HR:  89 bpm | Timestamp: 1142004520
 6. Power:  620W | Speed:  7.78 m/s | HR: 112 bpm | Timestamp: 1142015079
 7. Power:  619W | Speed:  5.56 m/s | HR:  95 bpm | Timestamp: 1142074257
 8. Power:  610W | Speed:  9.60 m/s | HR: 107 bpm | Timestamp: 1142010513
 9. Power:  601W | Speed:  8.90 m/s | HR: 107 bpm | Timestamp: 1142010512
10. Power:  600W | Speed:  6.59 m/s | HR:  80 bpm | Timestamp: 1142006424
11. Power:  598W | Speed:  3.83 m/s | HR:  99 bpm | Timestamp: 1142171931
12. Power:  596W | Speed:  4.84 m/s | HR:  86 bpm | Timestamp: 1142032946
13. Power:  585W | Speed:  5.43 m/s | HR:  80 bpm | Timestamp: 1142006423
14. Power:  578W | Speed:  8.74 m/s | HR: 113 bpm | Timestamp: 1142121067
15. Power:  577W | Speed:  8.22 m/s | HR: 123 bpm | Timestamp: 1142016529
Question 2 Results:
Day 1: 3186 records with HR > 110 bpm
Day 2: 1967 records with HR > 110 bpm
Day 3: 482 records with HR > 110 bpm
Day 4: 560 records with HR > 110 bpm

Total across all 4 days: 6195 times HR exceeded 110 bpm


These were the results I got using merge sort and binary search.