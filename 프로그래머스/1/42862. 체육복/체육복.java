import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여분 가져온 학생
        Set<Integer> reserveSet = new HashSet<>();
        
        // 도난 당한 학생
        Set<Integer> lostSet = new HashSet<>();
        
        // 여분 가져온 학생 Set에 추가
        for(int i : reserve){
            reserveSet.add(i);
        }
        
        // 도난 당한 학생 Set 추가
        // 만약 여분 있는 학생이 도난당한 경우 reserveSet에서 제거
        for (int i : lost){
            if(reserveSet.contains(i)){
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }
        
        // 여분 있는 학생이 앞뒤 중 한 학생에게 빌려주고
        // 빌린 학생은 lostSet에서 제거
        for(int i : reserveSet) {
            if (lostSet.contains(i-1)) {
                lostSet.remove(i-1);
            } else if (lostSet.contains(i+1)) {
                lostSet.remove(i+1);
            }
        }
        
        return n - lostSet.size();
    }
}