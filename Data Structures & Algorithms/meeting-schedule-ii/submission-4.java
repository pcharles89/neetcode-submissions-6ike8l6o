class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()){
            return 0;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && interval.start >= minHeap.peek()){
                minHeap.poll();
            }

            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}
