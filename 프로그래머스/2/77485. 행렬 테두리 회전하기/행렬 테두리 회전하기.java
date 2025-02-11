class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        // 행렬 선언. 행: 0~rows, 열: 0~columns. 0행 0열은 사용x
        int[][] matrix = new int[rows+1][columns+1];
        
        // 행렬 초기화 i행 j열의 수는 (i-j)*columns+j
        for(int i=1; i < rows+1; i++){
            for(int j=1; j < columns+1; j++){
                matrix[i][j] = (i-1)*columns + j;
            }
        }
        
        // 최솟값을 담을 배열
        int[] answer = new int[queries.length];
        
        
        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
             
            int min = matrix[x1][y1];
            int start = matrix[x1][y1];
                        
            // x1, y1 ~ x1, y2까지 중 최소 갱신 (위)
            int temp = matrix[x1][y2]; // 오른쪽 위 값 임시 저장
            
            for(int tempCol=y2; tempCol>y1; tempCol--){
                if(min > matrix[x1][tempCol])
                    min = matrix[x1][tempCol];
                matrix[x1][tempCol] = matrix[x1][tempCol-1];
            }
            
            // x1, y1 ~ x2, y1까지 중 최소 갱신 (왼쪽)
            for(int tempRow=x1; tempRow<x2; tempRow++){
                if(min > matrix[tempRow][y1])
                    min = matrix[tempRow][y1];
                matrix[tempRow][y1] = matrix[tempRow+1][y1];
            }
            
            // x2, y1 ~ x2, y2까지 중 최소 갱신 (아래)
            for(int tempCol=y1; tempCol<y2; tempCol++){
                if(min > matrix[x2][tempCol])
                    min = matrix[x2][tempCol];
                matrix[x2][tempCol] = matrix[x2][tempCol+1];
            }
            
            // x1, y2 ~ x2, y2까지 중 최소 갱신 (오른쪽)
            for(int tempRow=x2; tempRow>x1; tempRow--){
                if(min > matrix[tempRow][y2])
                    min = matrix[tempRow][y2];
                matrix[tempRow][y2] = matrix[tempRow-1][y2];
            }
            
            matrix[x1+1][y2] = temp;
            
            answer[i] = min;   
        }
        
        return answer;
    }
}
