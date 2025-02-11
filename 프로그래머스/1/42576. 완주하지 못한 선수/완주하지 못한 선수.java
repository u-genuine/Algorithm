// 한명 뺴고 완주함
// 모든 선수 이름 배열 paricipant, 완주 이름 배열 completion
// participant에서 completion을 제거하고 남은 사람을 return

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 키 = 이름, 값 = 인원
        HashMap<String, Integer> map = new HashMap<>();
        
        // 동명이인이 있는 경우 기존 인원 + 1
        for(String player: participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // 완주자 제거
        for(String player: completion){
            map.put(player, map.get(player) - 1);
        }
        
        // 값이 0이 아닌 이름은 완주하지 못 한 사람이니까 답이 됨
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}