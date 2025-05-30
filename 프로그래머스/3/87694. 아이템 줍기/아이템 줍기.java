import java.util.*;

class Solution {
    static int[] dx = new int[]{0, 0, -1, 1};
	static int[] dy = new int[]{1, -1, 0, 0};

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
		Boolean[][] road = new Boolean[101][101];
		for(int[] one : rectangle) {
			int x1 = one[0] * 2;
			int y1 = one[1] * 2;
			int x2 = one[2] * 2;
			int y2 = one[3] * 2;

			for(int x = x1; x <= x2; x++) {
				for(int y = y1; y <= y2; y++) {
					if(road[x][y] != Boolean.FALSE) { // 기존 테두리의 내부가 아님
						if(x == x1 || x == x2 || y == y1 || y == y2) {
							road[x][y] = true;
						} else {
							road [x][y] = false;
						}
					}
				}
			}
		}


		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {characterX * 2, characterY * 2, 0});
        boolean[][] visit = new boolean[101][101];
        visit[characterX * 2][characterY * 2] = true;

		while(!queue.isEmpty()) {
			int[] current = queue.poll();
            
            if(current[0] == itemX * 2 && current[1] == itemY * 2) {
                return current[2] / 2;
            }
            
			for(int i = 0; i < 4; i++) {
				int nextX = current[0] + dx[i];
				int nextY = current[1] + dy[i];

				if(nextX >= 0 && nextX < 101 && nextY >= 0 && nextY < 101) {
					if(road[nextX][nextY] == Boolean.TRUE && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
						queue.add(new int[] {nextX, nextY, current[2] + 1});
					}
				}
			}
		}

		return 0;
	}
}