import java.util.*;

class Solution {
    static int index = 1;
    static HashMap<String, Integer> map = new HashMap<>();
    static char[] dict = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        for(char c : dict) {
            DFS(1, String.valueOf(c));
        }
        
        return map.get(word);
    }
    
    void DFS(int length, String str) {
        if(str.length() > 5) {
            return;
        }
        map.put(str, index);
        index++;
        for(char c : dict) {
            DFS(length + 1, str + c);
        }
    }
}