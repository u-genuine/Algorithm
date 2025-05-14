import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[100001];
		int start = 0, end = 0;
		int max = 0;

		while(start < N && end < N) {
			int current = arr[end];

			if(count[current] < K) {
				count[current]++;
				end++;
				max = Math.max(max, end - start);
			} else {
				count[arr[start]]--;
				start++;
			}
		}
		System.out.println(max);
	}
}