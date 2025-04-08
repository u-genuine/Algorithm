import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combi(0, 1);
        System.out.println(min);
    }
    
    static void combi(int count, int start) {
        if(count == N/2){
            min = Math.min(min, calculate());
            return;
        }
        
        for(int i = start; i < N+1; i++) {
                visited[i] = true;
                combi(count+1, i+1);
                visited[i] = false;
            
        }
    }

    static int calculate() {
        int start = 0;
        int link = 0;
        
        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                if(i == j) {
                    continue;
                }
                if(visited[i] && visited[j]) {
                    start += map[i][j];
                }
                if(!visited[i] && !visited[j]) {
                    link += map[i][j];
                }
            }
        }
        return Math.abs(start-link);
    }   
}