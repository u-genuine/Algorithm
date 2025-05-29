/*
BFS로 1씩 증가하다가 목적지 오면 값 리턴
*/

import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visit;
    static int[][] count;
    
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        count = new int[maps.length][maps[0].length];
        
        queue.add(new int[]{0, 0});
        
        for (int i = 0; i < count.length; i++) {
            Arrays.fill(count[i], -1);
        }
        
        count[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int[] next = new int[]{current[0] + dx[i], current[1] + dy[i]};
                
                if(next[0] >= 0 && next[0] < maps.length && next[1] >= 0 && next[1] < maps[0].length) {
                    if(maps[next[0]][next[1]] == 1 && !visit[next[0]][next[1]]) {
                        queue.add(new int[]{next[0], next[1]});
                        visit[next[0]][next[1]] = true;
                        count[next[0]][next[1]] = count[current[0]][current[1]] + 1;
                    }
                }
            }
        }
        return count[maps.length-1][maps[0].length-1];
    }
}