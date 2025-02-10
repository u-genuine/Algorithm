class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // count[0] : 최대 당첨 숫자 개수, count[1] : 최소 당첨 숫자 개수
        int[] count = {0, 0};
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                count[0]++;
            }
            
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    count[0]++;
                    count[1]++;
                }
            }
        }
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];
        
        answer[0] = rank[count[0]];
        answer[1] = rank[count[1]];
        
        return answer;
        
        
    }
}