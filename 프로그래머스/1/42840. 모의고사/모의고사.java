import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 답 찍는 패턴 배열
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 3명의 정답 개수 배열
        int[] score = new int[3];
        
        // 답이 맞으면 점수++
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supo1[i % supo1.length]) 
                score[0]++;
            if(answers[i] == supo2[i % supo2.length])
                score[1]++;
            if(answers[i] == supo3[i % supo3.length])
                score[2]++;
        }
        
        // 3명 중 최고 점수
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 최다 정답자 인원 세기
        int count = 0;
        for(int s : score) {
            if (s == maxScore)
                count ++;
        }
        
        // 최다 정답자 인원만큼 배열 생성
        int[] result = new int[count];
        
        // 점수가 최고점인 사람을 정답 배열에 추가
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if(score[i] == maxScore){
                result[index] = i + 1;
                index++;
            }
        }
        
        return result;
    }
}