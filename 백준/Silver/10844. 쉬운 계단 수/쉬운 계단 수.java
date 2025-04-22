import java.util.*;

class Main {
	static Long[][] dp;
	static int MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new Long[N + 1][10];

		Arrays.fill(dp[1], 1L);

		long result = 0;

		for (int i = 1; i <= 9; i++) {
			result += recur(N, i);
		}

		System.out.println(result % MOD);
	}

	static long recur(int N, int num) {
		if(N == 1) {
			return 1;
		}

		if (dp[N][num] == null) {
			if (num == 0) {
				dp[N][num] = recur(N - 1, 1);
			} else if (num == 9) {
				dp[N][num] = recur(N - 1, 8);
			} else {
				dp[N][num] = recur(N - 1, num - 1) + recur(N - 1, num + 1);
			}
		}
		
		return dp[N][num] % MOD;
	}
}
