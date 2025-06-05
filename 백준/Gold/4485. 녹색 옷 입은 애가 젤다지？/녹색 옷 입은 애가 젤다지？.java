import java.io.*;
import java.util.*;

public class Main {
	static Integer[][] dp;
	static int[] dn = new int[] {-1, 1, 0, 0};
	static int[] dm = new int[] {0, 0, -1, 1};

	static int N;
	static int[][] map;
	static int[][] distance;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problemNumber = 1;

		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;

			map = new int[N][N];
			distance = new int[N][N];

			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			int result = dijkstra();
			System.out.println("Problem " + problemNumber + ": " + result);
			problemNumber++;
		}
	}

	static int dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

		distance[0][0] = map[0][0];
		pq.add(new int[]{0, 0, map[0][0]});

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int row = cur[0];
			int col = cur[1];
			int cost = cur[2];

			if(cost > distance[row][col]) continue;

			if(row == N - 1 && col == N - 1) return cost;

			for(int i = 0; i < 4; i++) {
				int nextRow = row + dn[i];
				int nextCol = col + dm[i];

				if(nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
					int nextCost = cost + map[nextRow][nextCol];

					if(nextCost < distance[nextRow][nextCol]) {
						distance[nextRow][nextCol] = nextCost;
						pq.offer(new int[] {nextRow, nextCol, nextCost});
					}
				}
			}

		}
		return 0;
	}
}