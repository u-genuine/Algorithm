import java.io.*;
import java.util.*;

class Main {
    static boolean[][] labtop;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노트북 세로
        int M = Integer.parseInt(st.nextToken()); // 노트북 가로
        labtop = new boolean[N][M];
        
        int K = Integer.parseInt(st.nextToken()); // 스티커 개수
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()); // 스티커 행
            int C = Integer.parseInt(st.nextToken()); // 스티커 열
            
            boolean[][] sticker = new boolean[R][C];
            for(int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < C; c++) {
                    boolean one = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                    sticker[r][c] = one;
                }
            }

            int tempR = R;
            int tempC = C;
            boolean success = false;
            int turnCnt = 0;
            while(!success && turnCnt < 4) {
                // n, m은 노트북에서 스티커의 왼쪽 상단이 놓일 좌표
                for(int n = 0; n < N - tempR + 1; n++) {
                    for(int m = 0; m < M - tempC + 1; m++) {
                        if(canPut(n, m, tempR, tempC, sticker)) {
                            putSticker(n, m, tempR, tempC, sticker);
                            success = true;
                            break;
                        }
                    }
                    if(success) break; 
                }
                if(success) break;

                // 원본 못붙인 경우
                sticker = turn(tempR, tempC, sticker); // 회전
                int temp = tempR;
                tempR = tempC;
                tempC = temp;
                turnCnt++;
            }
        }

        System.out.println(answer);
    }

    static boolean canPut(int n, int m, int r, int c, boolean[][] sticker) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!sticker[i][j]) continue;
                if(labtop[n+i][m+j]) return false;
            } 
        }
        return true;
    }

    static void putSticker(int n, int m, int r, int c, boolean[][] sticker) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(sticker[i][j]) {
                    labtop[n+i][m+j] = true;
                    answer++;
                }
            } 
        }
    }
    
    static boolean[][] turn(int r, int c, boolean[][] sticker) {
        boolean[][] turnedSticker = new boolean[c][r];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                turnedSticker[j][r-i-1] = sticker[i][j];
            }
        }
        
        return turnedSticker;
    }
    
}