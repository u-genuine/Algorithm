import java.util.*;

class Solution {
    public int[] solution(String[] operations){
        StringTokenizer st;
        Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        HashSet<Integer> nums = new HashSet<>();
        
        for(int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")) {
                maxQueue.add(num);
                minQueue.add(num);
                nums.add(num);
            } else if (num == 1) {
                if(!maxQueue.isEmpty() && !nums.isEmpty()) {
                    while(true){
                        int temp = maxQueue.poll();
                        if(nums.contains(temp)){
                            nums.remove(temp);
                            break;
                        }
                    }
                }
            } else {
                if(!minQueue.isEmpty() && !nums.isEmpty()) {
                    while(true){
                        int temp = minQueue.poll();
                        if(nums.contains(temp)){
                            nums.remove(temp);
                            break;
                        }
                    }
                }
            }
        }

        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] answer;
        if(nums.isEmpty()){
            answer = new int[]{0, 0};
        } else {
            for(int i : nums){
                if(max < i){
                    max = i;
                }
                if(min > i) {
                    min = i;
                }
            }
            answer = new int[]{max, min};
        }
        
        return answer;
    }
}