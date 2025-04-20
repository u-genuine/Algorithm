import java.util.*;

class Solution {
    public int solution(int[][] jobs) {        
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int time = 0;
        int total = 0;
        int count = 0;
        int index = 0;
        
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= time){
                queue.add(jobs[index++]);  
            }
            
            if(!queue.isEmpty()){
                int[] temp = queue.poll();
                time += temp[1];
                total += time - temp[0];
                count++;
            } else {
                time = jobs[index][0];
                
            }
            
        }
        
        return total / jobs.length;
    }
}