import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] taller = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			taller[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[N + 1];
		int[] result = new int[N + 1];

		for(int i = 1; i < N + 1; i++) {

			int temp = 0;
			for(int j = 1; j < N + 1; j++) {
				if(!visited[j]) {
					if(temp == taller[i]) {
						result[j] = i;
						visited[j] = true;
						break;
					} else {
						temp++;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) {
			sb.append(result[i]);
			sb.append(" ");
		}
		System.out.println(sb);

	}
}