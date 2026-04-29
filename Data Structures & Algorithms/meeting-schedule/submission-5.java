class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            Interval previous = intervals.get(i - 1);

            if(previous.end > current.start){
                return false;
            }
        }

        return true;
    }
}
