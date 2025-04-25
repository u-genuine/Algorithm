import java.io.*;
import java.util.*;

class Main {
	static Long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new Long[N+1][K+1];

		long num = comb(N, K);
		System.out.println(num);
	}

	static long comb(int n, int k) {
		if(dp[n][k] != null) {
			return dp[n][k];
		}

		if(k == 0 || n == k){
			return dp[n][k] = 1L;
		}

		return dp[n][k] = (comb(n-1, k-1) + comb(n-1, k)) % 10007;
	}
}
