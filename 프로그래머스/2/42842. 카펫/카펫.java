/*
brown + yellow의 약수 찾기
n x m 일때, n, m 둘 다 2보다 커야함

24, 24 = 48 = 세로*가로 = 3*16, 4*12, 6*8
가로 X 2 + 세로 - 4 = 24 를 만족하면
    가로, 세로를

*/
import java.util.*;

class Solution {
    
    public List<int[]> findDivisor(int number){
        List<int[]> divisors = new ArrayList<>();
        
        for(int i = 3; i <= Math.sqrt(number); i++) {
            if(number % i == 0)
                divisors.add(new int[]{number/i, i}); // 가로, 세로
        }
        
        return divisors;
    }
    
    public int[] solution(int brown, int yellow) {
        int tiles = brown + yellow;
        
        List<int[]> divisors = findDivisor(tiles);
        
        for(int[] one : divisors) {
            if((one[0]+one[1])*2 - 4 == brown) {
                return one;
            }
        }
        
        return null;
    }
}