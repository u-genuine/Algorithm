/*
numbers를 한글자씩 잘라서 숫자 배열 만들기.
*/

import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
    public boolean isPrime(int number){
        // 0과 1은 소수가 아니다
        if(number == 0 || number == 1)
            return false;
        
        int limit = (int)Math.sqrt(number);
        for(int i = 2; i <= limit; i++) {
            if(number % i == 0)
                return false;
        }
        
        return true;
    }
    public void recursive(String comb, String others) {
        // 1. 현재 조합을 Set에 추가
        if(!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));    
        }
                
        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }
    
    public int solution(String numbers) {
        int count = 0;
        
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        
        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number))
                count++;
        }
        
        return count;
    }
}