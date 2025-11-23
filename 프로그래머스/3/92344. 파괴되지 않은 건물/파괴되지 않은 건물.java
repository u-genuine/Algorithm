class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        int[][] diff = new int[N][M];
        
        for(int[] one : skill) {
            int type = one[0];
            int r1 = one[1];
            int c1 = one[2];
            int r2 = one[3];
            int c2 = one[4];
            int degree = one[5];
            
            if(type == 1) { // 공격
                diff[r1][c1] -= degree;
                if(r2 < N - 1) diff[r2+1][c1] += degree;
                if(c2 < M - 1) diff[r1][c2+1] += degree;
                if(r2 < N - 1 && c2 < M - 1) diff[r2+1][c2+1] -= degree;
            } else {
                diff[r1][c1] += degree;
                if(r2 < N - 1) diff[r2+1][c1] -= degree;
                if(c2 < M - 1) diff[r1][c2+1] -= degree;
                if(r2 < N - 1 && c2 < M - 1) diff[r2+1][c2+1] += degree;
            }
        }
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M - 1; c++) {
                diff[r][c+1] += diff[r][c];
            }
        }
        
        for(int c = 0; c < M; c++) {
            for(int r = 0; r < N - 1; r++) {
                diff[r+1][c] += diff[r][c];
            }
        }
        
        int count = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                board[r][c] += diff[r][c];
                if(board[r][c] > 0) count++;
            }
        }
        
        return count;
    }
}


/*
0 0 0 0
0 -2 0 +2
0 0 0 0
0 +2 0 -2
*/