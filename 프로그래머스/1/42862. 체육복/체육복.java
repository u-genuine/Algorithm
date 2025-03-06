class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+2];
        
        for(int i : lost) {
            student[i]--;
        }
        
        for(int i : reserve){
            student[i]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(student[i] == 1) {
                if(student[i-1] == -1) {
                    student[i-1]++;
                    student[i]--;
                } else if(student[i+1] == -1){
                    student[i+1]++;
                    student[i]--;
                }
            } 
        }
         
        int count = n;
        
        for(int i = 1; i <= n; i++) {
            if(student[i] < 0){
                count--;
            }
        }
        
        return count;
            
    }
}