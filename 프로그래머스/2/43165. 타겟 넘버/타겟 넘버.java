class Solution {
    int[] numbers;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        answer = 0;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int index, int sum){
        // 1. 탈출 조건
        if(index == numbers.length){
            if (sum == target)
                answer++;
            return;
        }
        
        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
        
    }
}