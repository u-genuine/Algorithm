import java.util.HashMap;
// 접두어인 경우가 있으면 false, 없으면 true
// phone_book의 모든 번호 해시 맵에 추가 <번호, 1>
// 해시 맵 하나씩 돌면서 접두어가 맵에 있는지 확인. 있으면 false 리턴
// true 리턴


class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 맵에 전화번호 추가
        for (int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], 1);            
        }
        
        for (int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++)
                if(map.containsKey(phone_book[i].substring(0, j))) {
                   return false;
                }
        }
        return true;
    }
}