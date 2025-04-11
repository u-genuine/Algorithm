import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] lines = new int[K];
		long left = 1;
		long right = 0;
		for(int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, lines[i]);
		}

		while(left <= right) {
			long mid = (left + right) / 2;
			int count = 0;
			
			for(int line : lines) {
				count += line / mid;
			}

			if(count < N) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(right);
	}
}