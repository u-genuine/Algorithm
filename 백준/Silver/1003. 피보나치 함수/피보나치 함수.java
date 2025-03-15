import java.util.*;

class Main{
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		dp = new int[41][2];
		for(int i = 0; i < 41; i++){
			Arrays.fill(dp[i], -1);
		}

		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for(int i = 0; i < T; i++){
			int N = sc.nextInt();
			int[] answer = recur(N);
			sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
		}

		System.out.println(sb);
	}

	public static int[] recur(int N) {
		if(N <= 1){
			return dp[N];
		} else if (dp[N][0] == -1) {
			int[] first = recur(N-1);
			int[] second = recur(N-2);
			dp[N][0] = first[0] + second[0];
			dp[N][1] = first[1] + second[1];
		}
		return dp[N];
	}
}