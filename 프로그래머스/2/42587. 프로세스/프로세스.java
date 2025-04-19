import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> priority = new PriorityQueue<>((o1, o2) -> o2 - o1); // 우선순위 내림차순
        Queue<int[]> process = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < priorities.length; i++) {
            priority.add(priorities[i]);
            int[] temp = {i, priorities[i]};
            process.add(temp);
        }
        
        int answer = 1;
        while(!process.isEmpty()) {
            int[] current = process.peek(); 
            if(current[1] == priority.peek()){
                if(current[0] == location){
                    return answer;
                }
                priority.poll();
                answer++;
            } 
            process.poll();
            process.add(current);
        }
        
        return answer;
    }
}