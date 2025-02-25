/*
n개의 논문 중
h번 이상 인용된 논문이 h편 이상인 h의 최댓값
*/
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < n; i++){
            int h = n - i; // h: citations[i]번 이상 인용된 논문 개수
            if(citations[i] >= h)
                return h;
        }
        return 0;
    }
}