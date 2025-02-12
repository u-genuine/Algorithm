import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 반환
        String[] strNums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strNums[i] = String.valueOf(numbers[i]);
        }
        
        // 두 수를 이어붙였을 때 더 큰 수가 되는 순서로 정렬
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        // 가장 큰 수가 0이면 "0" 반환 (모든 수가 0인 경우)
        if(strNums[0].equals("0")) {
            return "0";
        }
        
        // 정렬이 된 문자열 이어붙이기
        String answer = String.join("", strNums);
        return answer;
    }
}