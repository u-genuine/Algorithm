import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] chart = new int[N];
			for (int i = 0; i < N; i++) {
				chart[i] = Integer.parseInt(st.nextToken());
			}

			int max = chart[chart.length - 1];
			long result = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (chart[i] < max) {
					result += max - chart[i];
				} else if (chart[i] >= max) {
					max = chart[i];
				}
			}
			sb.append(result).append("\n");
		}

		System.out.print(sb);

	}
}