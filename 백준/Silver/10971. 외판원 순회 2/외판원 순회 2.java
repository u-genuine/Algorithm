import java.io.*;
import java.util.*;

class Main {
	static boolean[] visited;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		TSP(0, 1, 0);
		System.out.println(result);
	}

	static void TSP(int now, int count, int cost) {
		if(map[now][0] != 0 && count == N) {
			result = Math.min(result, cost + map[now][0]);
			return;
		}

		for(int next = 1; next < N; next++) {
			if(map[now][next] != 0 && !visited[next]) {
				visited[next] = true;
				TSP(next, count + 1, cost + map[now][next]);
				visited[next] = false;
			}
		}

	}
}