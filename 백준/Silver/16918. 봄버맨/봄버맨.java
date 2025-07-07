import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];

		// 초기 상태
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				if(line.charAt(j) == 'O') {
					map[i][j] = 3;
				} else {
					map[i][j] = 0;
				}
			}
		}

		for(int time = 2; time <= N; time++) {
			if(time % 2 == 0) {
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(map[i][j] == 0) {
							map[i][j] = time + 3;
						}
					}
				}
			} else {
				boolean[][] boom = new boolean[R][C];
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(map[i][j] == time) {
							boom[i][j] = true;
						}
					}
				}

				// 폭발
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(boom[i][j]) {
							map[i][j] = 0;
							for(int k = 0; k < 4; k++) {
								int nr = i + dr[k];
								int nc = j + dc[k];
								if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
									if(map[nr][nc] != time) {
										map[nr][nc] = 0;
									}
								}
							}
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					sb.append(".");
				} else {
					sb.append("O");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}