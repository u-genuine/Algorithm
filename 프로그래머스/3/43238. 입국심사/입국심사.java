import java.util.*;

class Solution {
    int n;
    int[] times;
    
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        
        Arrays.sort(times);
        return binarySearch(0, (long)times[times.length-1]*n);
    }
    
    long binarySearch(long left, long right){
        if(left>right)
            return left;
        
        long mid = (left + right) / 2;
        
        long complete = 0;
        for(int time : times) {
            complete += mid / time;
        }
        
        if (complete < n) {
            return binarySearch(mid+1, right);
        } else { 
            return binarySearch(left, mid-1);
        }
    }
}