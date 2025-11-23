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