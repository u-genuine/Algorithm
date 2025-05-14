import java.io.*;
import java.util.*;

public class Main {
	static int[] dn = {1, -1, 0, 0};
	static int[] dm = {0, 0, -1, 1};
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	static int[] target;

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		map = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];
		target = new int[2];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					target[0] = i;
					target[1] = j;
				}
			}
		}
		BFS(target[0], target[1]);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					sb.append(-1 + " ");
				} else {
					sb.append(result[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void BFS(int n, int m) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n, m});
		visited[n][m] = true;

		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextN = current[0] + dn[i];
				int nextM = current[1] + dm[i];

				if(nextN >= 0 && nextN < N && nextM >= 0 && nextM < M) {
					if (!visited[nextN][nextM] && map[nextN][nextM] == 1) {
						queue.add(new int[]{nextN, nextM});
						result[nextN][nextM] = result[current[0]][current[1]] + 1;
						visited[nextN][nextM] = true;
					}
				}
			}
		}
	}
}