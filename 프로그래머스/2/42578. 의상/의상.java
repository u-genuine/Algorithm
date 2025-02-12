import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] one : clothes){
            map.put(one[1], map.getOrDefault(one[1], 0)  + 1);
        }
        
        int answer = 1;
        
        // 조합. 지금 key에서 선택을 안 하는 경우를 고려해서 + 1
        for(String key : map.keySet()){
            answer*= map.get(key) + 1; 
        }
        
        // 모두 안 입는 경우 제외
        answer -= 1; 
        
        return answer;
    }
}