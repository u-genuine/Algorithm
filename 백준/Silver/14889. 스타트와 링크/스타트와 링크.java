import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] S;
	static int min = Integer.MAX_VALUE;
	static boolean[] inStart;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		inStart = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		inStart[1] = true;
		DFS(1, 2);

		System.out.println(min);
	}

	static void DFS(int count, int idx) {
		if (idx == N + 1) {
			if (count == N/2) {
				min = Math.min(min, calcS());
			}
			return;
		}

		inStart[idx] = true;
		DFS(count + 1, idx + 1);
		inStart[idx] = false;
		DFS(count, idx + 1);
	}

	static int calcS() {
		int start = 0;
		int link = 0;

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(inStart[i]) {
					if(inStart[j]) {
						start += S[i][j];
					}
				} else {
					if(!inStart[j]) {
						link += S[i][j];
					}
				}
			}
		}

		return Math.abs(start - link);
	}
}