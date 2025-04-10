import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int M;
    static int[] video;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		video = new int[N];
		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			video[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, video[i]);
			right += video[i];
		}

		int result = binarySearch(left, right);
		System.out.println(result);

	}

	static int binarySearch(int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			int count = 1;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				if (sum + video[i] > mid) {
					count++;
					sum = 0;
				}
				sum += video[i];
			}

			if (count <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}