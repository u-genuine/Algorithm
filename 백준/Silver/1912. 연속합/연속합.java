import java.util.*;
import java.io.*;

class Main{
	static Integer[] dp;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		dp = new Integer[T];
		arr = new int[T];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < T; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];
		max = dp[0];
		
		recur(T-1);

		System.out.println(max);
	}

	public static int recur(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(recur(N-1) + arr[N], arr[N]);
			if(dp[N] > max) {
				max = dp[N];
			}
		}

		return dp[N];
	}
}