import java.util.*;
// 최대 nums.length/2 만큼 고를 수 있음
// nums에서 중복되는 원소를 버림
// 버린 후 남은 원소 개수가 nums.length/2 보다 작으면 버린 후 남은 원소 개수가 답. 더 크면 nums.length/2가 답


class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int len = nums.length / 2;
        
        // 중복 원소를 버리기 위해 HashSet 활용
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        int size = set.size();
        
        if(size <= len){
            answer = size;
        } else {
            answer = len;
        }
        
        return answer;
    }
}