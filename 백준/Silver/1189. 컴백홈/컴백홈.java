import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static int K;
	static int result = 0;
	static int[] dx = new int[]{0, 0, -1, 1};
	static int[] dy = new int[]{1, -1, 0, 0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[R][C];

		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				if(line.charAt(j) == 'T'){
					visited[j][i] = true;
				}
			}
		}
		visited[R-1][0] = true;
		DFS(R-1, 0, 1);

		System.out.println(result);
	}

	static void DFS(int y, int x, int count){
		if(y == 0 && x == C-1) {
			if(count == K) {
				result ++;
				return;
			}
			return;
		}

		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if(nextX >= 0 && nextX < C &&
				nextY >= 0 && nextY < R) {
				if(!visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					DFS(nextY, nextX, count+1);
					visited[nextY][nextX] = false;
				}
			}
		}

	}
}