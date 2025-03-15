import java.util.*;

class Main{
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		dp = new int[11];
		Arrays.fill(dp, 0);

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i = 0; i < T; i++){
			int N = sc.nextInt();
			sb.append(recur(N)).append("\n");
		}
		System.out.println(sb);
	}

	public static int recur(int N) {
		if(dp[N] > 0) {
			return dp[N];
		} else {
			return dp[N] = recur(N-1) + recur(N-2) + recur(N-3);
		}
	}
}