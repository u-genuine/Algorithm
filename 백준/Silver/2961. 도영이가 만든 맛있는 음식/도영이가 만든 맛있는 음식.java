import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visit;
	static int[][] ingredient;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		ingredient = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N; i++) {
			visit[i] = true;
			DFS(i, ingredient[i][0], ingredient[i][1]);
			visit[i] = false;
		}

		System.out.println(min);
	}

	static void DFS(int index, int S, int B) {
		if(index == N - 1){
			min = Math.min(min, Math.abs(S - B));
			return;
		}
		for(int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				DFS(index + 1, S * ingredient[i][0], B + ingredient[i][1]);
				visit[i] = false;
				DFS(index + 1, S , B);
			}
		}
	}
}