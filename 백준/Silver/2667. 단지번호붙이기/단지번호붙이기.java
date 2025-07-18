import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = new int[]{-1, 1, 0, 0};
	static int[] dc = new int[]{0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] map;
	static int N;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");

			for(int j = 0; j < N; j++) {
				map[i][j] = line[j].equals("0") ? 0 : 1;
			}
		}

		int result = 0;
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					result++;
					count = 0;
					DFS(i, j);
					list.add(count);
				}
			}
		}

		Collections.sort(list);
		System.out.println(result);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static int DFS(int r, int c) {
		visited[r][c] = true;
		count++;

		for(int k = 0; k < 4; k++) {
			int nextR = r + dr[k];
			int nextC = c + dc[k];
			if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
				if(!visited[nextR][nextC] && map[nextR][nextC] == 1) {
					DFS(nextR, nextC);
				}
			}
		}

		return count;
	}
}
