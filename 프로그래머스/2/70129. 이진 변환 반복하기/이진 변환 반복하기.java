class Solution {
    public int[] solution(String s) {
        
        int count = 0;
        int removedZero = 0;
        while(s.length() > 1) {
            count++;
            
            int origin = s.length();
            s = s.replace("0", "");
            int modified = s.length();
            removedZero += origin - modified;
            
            int c = s.length();
            s = Integer.toBinaryString(c);
        }
        int[] answer = {count, removedZero};
        return answer;
    }
}

/*

*/