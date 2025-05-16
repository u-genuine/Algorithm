import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] distance = new int[D+1];
		int[][] arr = new int[N][3];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		distance[0] = 0;
		for(int i = 1; i < D+1; i++) {
			distance[i] = distance[i-1] + 1;
			for(int j = 0; j < N; j++) {
				if(arr[j][1] == i) {
					distance[i] = Math.min(distance[i], arr[j][2] + distance[arr[j][0]]);
				}
			}
		}

		System.out.println(distance[D]);
	}
}