import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int temp = n;
        StringBuilder sb = new StringBuilder();
        List<Integer> zeroIdx = new ArrayList<>();
        while(temp > 0) {
            int s = temp / k;
            int m = temp % k;
            sb.append(String.valueOf(m));
            temp = s;
        }
        
        String nk = sb.reverse().toString();
        String[] splitNums = nk.split("0");
        
        int answer = 0;
        for(int i = 0; i < splitNums.length; i++) {
            if(splitNums[i].equals("")) continue;
            long num = Long.parseLong(splitNums[i]);
            if(!isPrime(num)){
                continue;
            };
            
            answer++;
        }
        return answer;
    }
    
    boolean isPrime(long num) {
        if(num <= 1) return false;
        
        if(num == 2) return true;
        
        if(num % 2 == 0) return false;
        
        for(long i = 3; i * i <= num; i += 2) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}

/*
n을 k진수로 바꿔 = NK
0으로 슬라이싱을 해서 숫자 나눠 -> 10진수 값이 소수인지 판별
소수라면 조건 확인 (시작 인덱스, 끝 인덱스 필요)
- 시작 인덱스가 0이면
    - 끝 인덱스가 끝이거나(P) || 끝 인덱스 + 1 값이 0이면 (P0) => P 만족
- 시작 인덱스 - 1 값이 0 이면
    - 끝 인덱스 값이 끝이거나 (0P) || 끝 인덱스 + 1 값이 0 이면 (0P0) => P 만족
*/