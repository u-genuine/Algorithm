import java.io.*;
import java.util.*;

class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited1;
	static boolean[][] visited2;
	static String[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];

		int count1 = 0;
		int count2 = 0;

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = String.valueOf(line.charAt(j));
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited1[i][j]) {
					count1++;
					BFS1(i, j);
				}
				if(!visited2[i][j]) {
					count2++;
					BFS2(i, j);
				}
			}
		}

		System.out.println(count1 + " " + count2);
	}
	static void BFS1(int row, int col) {
		visited1[row][col] = true;
		String current = map[row][col];

		for(int i = 0; i < 4; i++) {
			int nextX = row + dx[i];
			int nextY = col + dy[i];
			if(nextX >= 0 && nextX <= N-1 &&
				nextY >= 0 && nextY <= N-1) {
				if(!visited1[nextX][nextY] &&
					map[nextX][nextY].equals(current)) {
					BFS1(nextX, nextY);
				}
			}
		}
	}

	static void BFS2(int row, int col) {
		visited2[row][col] = true;
		String current = map[row][col];

		for(int i = 0; i < 4; i++) {
			int nextX = row + dx[i];
			int nextY = col + dy[i];
			if(nextX >= 0 && nextX <= N-1 &&
				nextY >= 0 && nextY <= N-1) {
				if(!visited2[nextX][nextY] &&
					(map[nextX][nextY].equals(current) ||
					current.equals("R") && map[nextX][nextY].equals("G") ||
					current.equals("G") && map[nextX][nextY].equals("R"))) {
					BFS2(nextX, nextY);
				}
			}
		}
	}
}
