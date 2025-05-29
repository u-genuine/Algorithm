/*
-로 한번 +로 한번?
2^숫자개수 2^20 충분하네~
*/

class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        boolean[] plus = new boolean[numbers.length];
        DFS(numbers, target, 0, plus);
        
        return answer;
    }
    
    void DFS(int[] numbers, int target, int depth, boolean[] plus) {
        if(depth == numbers.length) {
            int result = 0;
            for(int i = 0; i < numbers.length; i++) {
                if(plus[i]) {
                    result += numbers[i];
                } else {
                    result -= numbers[i];
                }
            }
            
            if(result == target) {
                answer++;
            }
            return;
        }
        
        plus[depth] = true;
        DFS(numbers, target, depth + 1, plus);
        plus[depth] = false;
        DFS(numbers, target, depth + 1, plus);
    }
}