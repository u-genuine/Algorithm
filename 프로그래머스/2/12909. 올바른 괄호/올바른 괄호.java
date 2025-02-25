/*
큐에 다 집어넣고

if(')'로 시작하면)
    false
else 
    '(' 하나 뺄때마다 count+1
    ')' 하나 뺄때마다 count-1
    if(count < 0 )
        false
    다 뺐을때 count가 0이면 성공
*/

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char first = s.charAt(0);
        int count = 0;
        
        if(first == ')')
            answer = false;
        
        for(char i : s.toCharArray()) {
            if(i == '(') {
                count++;
            } else {
                count--;
            }
            
            if(count < 0)
                answer = false;
        }
        
        if(count > 0) {
            answer = false;
        }
        
        return answer;
    }
}