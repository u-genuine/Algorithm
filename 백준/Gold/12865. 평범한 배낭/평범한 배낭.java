/*
dp[i번째 아이템][무게]
*/
import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int things = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());

		int[] w = new int[things + 1];
		int[] v = new int[things + 1];
		int[][] dp = new int[things+1][maxWeight+1];

		for(int i = 1; i <= things; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= things; i++) {
			for(int j = 1; j <= maxWeight; j++) {
				dp[i][j] = dp[i-1][j];

				if(w[i] <= j)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
			}
		}

		System.out.println(dp[things][maxWeight]);
	}
}