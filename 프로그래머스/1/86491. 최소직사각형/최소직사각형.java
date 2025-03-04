/*
각각의 원소에 대해서 가로, 세로 중 긴 것이 앞에 오도록 새 배열 생성

새 배열에 대해서 
a = 가로 중 가장 긴 것
b = 세로 중 가장 긴 것

return a*b;
*/

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int[][] sizes2 = new int[sizes.length][2];
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]){
                sizes2[i] = sizes[i];
            } else {
                sizes2[i][0] = sizes[i][1];
                sizes2[i][1] = sizes[i][0];
            }
        }
        
        int maxW = 0;
        int maxH = 0;
        
        for (int[] one : sizes2) {
            if(one[0] > maxW) {
                maxW = one[0];
            }
            if(one[1] > maxH) {
                maxH = one[1];
            }
        }
        
        return maxW*maxH;
    }
}
