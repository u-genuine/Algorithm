import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물지수, 다음달 받을 선물 수 저장
        Map<String, Integer> nameToIndex = new HashMap<>();

        int[] giftScore = new int[friends.length];
        int[][] nextMonthGift = new int[friends.length][friends.length];
        int[][] giftMap = new int[friends.length][friends.length];
        
        for(int i = 0; i < friends.length; i++) {
            nameToIndex.put(friends[i], i);
        }
        
        for(String gift : gifts) {
            String[] names = gift.split(" ");
            int from = nameToIndex.get(names[0]);
            int to = nameToIndex.get(names[1]);
            giftMap[from][to]++;
        }
        
        for(int i = 0; i < friends.length; i++) {
            int tempScore = 0;
            for(int j = 0; j < friends.length; j++) {
                tempScore += giftMap[i][j];
                tempScore -= giftMap[j][i];
            }
            giftScore[i] = tempScore;
        }
        
        
        for(int i = 0; i < friends.length; i++) {
            int give = 0;
            int take = 0;
            for(int j = i + 1; j < friends.length; j++) {
                if (giftMap[i][j] < giftMap[j][i]) { // 받은게 더 많으면
                    nextMonthGift[i][j]++;
                } else if (giftMap[i][j] > giftMap[j][i]) { // 준게 더 많으면
                    nextMonthGift[j][i]++;
                } else { // 같으면 
                    if(giftScore[i] > giftScore[j]) {
                        nextMonthGift[j][i]++;
                    } else if(giftScore[i] < giftScore[j]) {
                        nextMonthGift[i][j]++;
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < friends.length; i++) {
            int temp = 0;
            for(int j = 0; j < friends.length; j++) {
                temp += nextMonthGift[j][i];
            }
            if(max < temp) max = temp;
        }
        
        return max;
    }
}