package Heap_or_Priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetings_room_II {

    public static void main(String[] args) {
        int[][] intervals = { {10, 30}, {5, 10}, {15, 20}, {2, 6} };

        // Print the original intervals (for debugging)
        System.out.println("Input intervals: " + Arrays.deepToString(intervals));

        // Call the Meeting_room method and print result
        int requiredRooms = Meeting_room(intervals);
        System.out.println("Minimum number of meeting rooms required: " + requiredRooms);
    }

    public static int Meeting_room(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap ordered by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Add first meeting
        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // If the earliest finishing meeting is done before or when the next meeting starts,
            // they can reuse the same room.
            if (intervals[i][0] >= pq.peek()[1]) {
                pq.poll();
            }
            // Allocate a room for the current meeting (either reused or a new one)
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}