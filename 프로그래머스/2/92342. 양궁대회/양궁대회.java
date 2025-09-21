class Solution {
    static int maxGap = 0;
    static int[] result = new int[11];
    
    public int[] solution(int n, int[] info) {        
        DFS(0, n, new int[11], info);
      
        if (maxGap <= 0) {
            return new int[]{-1};
        }
        
        return result; 
    }
    
    public void DFS(int index, int arrows, int[] lion, int[] appeach) {
        if(index == 11) {
            lion[10] = arrows;
        
            int appeachScore = 0;
            int lionScore = 0;
                
            for (int i = 0; i < 11; i++) {
                if(appeach[i] < lion[i]) {
                    lionScore += (10 - i);
                } else if (appeach[i] > 0) {
                    appeachScore += (10 - i);
                }
            }
            
            int gap = lionScore - appeachScore;
            if(maxGap < gap || (gap == maxGap && isLowerScore(lion, result))) {
                maxGap = gap;
                result = lion.clone();
            }
        return;
        }
        
        DFS(index + 1, arrows, lion, appeach);
        
        if(arrows > appeach[index]) {
            lion[index] = appeach[index] + 1;
            DFS(index + 1, arrows - lion[index], lion, appeach);
            lion[index] = 0;
        }
    }
               
   private boolean isLowerScore(int[] lion, int[] result) {
       for(int i = 10; i >= 0; i--) {
           if(lion[i] != result[i]) {
               return lion[i] > result[i];
           }
       }
       
       return false;
   }
}