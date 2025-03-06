/*
CCACCCAAAACCC 9
    연속된 A 개수, 연속된 A가 시작하는 index, A가 끝나는 인덱스, 
    전체 문자열 vs index6 + A 뒤에 남은 개수
    
    A가 6 부터 시작하면, (6-1)*2 + 뒤에 남은 개수
*/

import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        
        int move = name.length() - 1; // 오른쪽으로만 쭉 갔을때 좌우 움직인 횟수
        
        for(int i = 0; i < name.length(); i++) {
            // 상하 움직인 횟수
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 지금 현재 i 기준으로 연속된 A가 끝나는 바로 다음 문자 위치 찾기
            index = i + 1;
            while(index < name.length() && name.charAt(index) == 'A'){
                index++;
            }
            
            // 오른쪽으로 먼저 갔다가 왼쪽으로 가는 경우
            move = Math.min(move, i * 2 + (name.length() - index));
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        
        answer += move;
        
        return answer;
    }
}