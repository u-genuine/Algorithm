import java.util.*;

class Solution {
    int maxCount = 0;
    int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] dcRate = new int[emoticons.length];
        dfs(0, dcRate, users, emoticons);
        
        return new int[]{maxCount, maxSales};
    }
    
    void dfs(int depth, int[] dcRate, int[][] users, int[] emoticons) {
        if(depth == emoticons.length) {
            calculate(dcRate, users, emoticons);
            return;
        }
        
        for(int dc = 10; dc <= 40; dc += 10) {
            dcRate[depth] = dc;
            dfs(depth + 1, dcRate, users, emoticons);
        }
    }
    
    void calculate(int[] dcRate, int[][] users, int[] emoticons) {
        int plusCount = 0;
        int totalSales = 0;
        
        for(int[] user : users) {
            int userRate = user[0];
            int userLimit = user[1];
            
            int sum = 0;
            for(int i = 0; i < emoticons.length; i++) {
                if(dcRate[i] >= userRate) {
                    sum += emoticons[i] * (100 - dcRate[i]) / 100;
                }
            }
            
            if(sum >= userLimit) {
                plusCount++;
            } else {
                totalSales += sum;
            }
        }
        
        if(plusCount > maxCount || (plusCount == maxCount && totalSales > maxSales)) {
            maxCount = plusCount;
            maxSales = totalSales;
        }
    }
}

/*
1. 임티플 가입자 
2. 임티 판매액

n명에게 임티 m개 할인해서 판매

사용자는
- 각자 정한 일정 비율 이상 할인하는 임티 모두 구매
- 구매 비용 합이 일정 가격이 넘어가면 -> 임티 구매 취소하고 임티플 가입


임티플을 구매하게 만들어야해
- 할인율이 '비율'로 해서 이모티콘 모두 구매할 때 '가격' 이상이면 -> 임티플카운트++

가격 내림차순 정렬
'비율' 의 최댓값으로 모두 셋팅


7000 9000 = 16000 //  16000 < '가격'이면 임티플 고려 X
40   40   = 9600  // 해당하는 비율 중 최소인거로 임티 다 샀을때 합이 < '가격' 이면 임티플 고려 X
40   30 = 4200 + 6300 = 10500
30   40 = 4900 + 5400 = 9900
30   30   = 11200
20   20   = 12800
10   10   = 14400

40, 10000 / 25, 10000
임티플 X / 임티플 O

*/