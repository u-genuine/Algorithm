import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numberStr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            String numStr = String.valueOf(numbers[i]);
            numberStr[i] = numStr;
        }
        
        Arrays.sort(numberStr, (a, b) -> (a + b).compareTo(b + a));
        
        if(numberStr[numberStr.length - 1].equals("0")) {
            return "0";
        }
        
        String answer = "";
        
        for(int i = numberStr.length - 1; i >= 0; i--) {
            answer += numberStr[i];
        }
        
        
        return answer;
    }
}