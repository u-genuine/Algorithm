import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			int N = Integer.parseInt(br.readLine());
			int[][] rank = new int[N][2];

			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int docs = Integer.parseInt(st.nextToken());
				int intv = Integer.parseInt(st.nextToken());
				rank[n] = new int[]{docs, intv};
			}

			Arrays.sort(rank, (a, b) -> Integer.compare(a[0], b[0]));
			int count = 1;
			int intv_min = rank[0][1];
			for(int i = 1; i < N; i++) {
				if(rank[i][1] < intv_min){
					count++;
					intv_min = Math.min(intv_min, rank[i][1]);
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);

	}
}