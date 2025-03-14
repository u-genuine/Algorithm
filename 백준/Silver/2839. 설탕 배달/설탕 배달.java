import java.io.*;
import java.util.*;

class Main{
	static int maxValue =  5000/3 + 1;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if(N<=5) {
			if(N == 5 || N == 3) {
				System.out.println(1);
			} else {
				System.out.println(-1);
			}
			return;
		}

		dp = new int[N+1];
		Arrays.fill(dp, maxValue);
		dp[3] = 1;
		dp[5] = 1;

		for(int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
		}

		System.out.println(dp[N] >= maxValue ? -1 : dp[N]);
	}

}