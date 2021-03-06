/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    if (intervals.isEmpty())
        return intervals;

    Collections.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            // TODO Auto-generated method stub
            return a.start - b.start;
        }
    });

    List<Interval> ans = new LinkedList<Interval>();
    Interval hold = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
        Interval current = intervals.get(i);
        if (hold.end >= current.start) {
            hold.end = Math.max(current.end, hold.end);
        } else {
            ans.add(hold);
            hold = current;
        }
    }

    if (!ans.contains(hold))
        ans.add(hold);

    return ans;
}
}
