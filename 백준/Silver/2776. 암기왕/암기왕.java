import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
		    StringBuilder sb = new StringBuilder();
			
            int N = Integer.parseInt(br.readLine());
			HashSet<Integer> set = new HashSet<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int target = Integer.parseInt(st.nextToken());
				if(set.contains(target)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}

			System.out.print(sb);
		}
	}
}
