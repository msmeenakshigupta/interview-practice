/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        int curMin = -1;
        while (!schedule.isEmpty()) {
            int localMin = Integer.MAX_VALUE;
            for (int i=0; i< schedule.size(); i++) {
                List<Interval> emp = schedule.get(i);
                localMin = Math.min(localMin, emp.get(0).start);
                while (!emp.isEmpty() && emp.get(0).start <= curMin) {
                    Interval interval = emp.remove(0);
                    curMin = Math.max(interval.end, curMin);
                }
            }
            if (localMin > curMin) {
                if (curMin > -1) ans.add(new Interval(curMin, localMin));
                curMin = localMin;
            }
            
            for (int i=schedule.size()-1; i>= 0; i--) 
                if (schedule.get(i).isEmpty()) schedule.remove(i);
        }
        return ans;
    }
}
