import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int[] command = commands[i];
            
            int[] tempArr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            
            Arrays.sort(tempArr);
            
            answer[i] = tempArr[command[2]-1];
        }
        
        return answer;
    }
}