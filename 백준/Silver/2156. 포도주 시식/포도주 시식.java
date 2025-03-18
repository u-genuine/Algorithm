/* 
연속 세잔 X -> 계단 오르기랑 비슷
n-3 -> n-1 -> n
n-2 -> n

포도주 배열 arr[] = {6, 10, 13, 9, 8}
그 계단까지 최대 양 dp[]

dp[n] = Math.max(dp[n-1], Math.max(dp[n-3] + arr[n-1], dp[n-2]) + arr[n])

계단 오르기와 다르게, 마지막 잔을 마시지 않는 경우도 따져봐야 함!!
*/
import java.io.*;
import java.util.*;

class Main{
	static Integer[] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		dp = new Integer[T + 1];
		arr = new int[T + 1];

		for(int i = 1; i < T + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] =	arr[1];

		System.out.println(recur(T));
	}

	static int recur(int N) {
		if(dp[N] != null) {
			return dp[N];
		}

		if (N <= 2){
			dp[N] = dp[N-1] + arr[N];
		} else {
			dp[N] = Math.max(recur(N-1),
				Math.max(recur(N-3) + arr[N-1], recur(N-2)) + arr[N]);
		}

		return dp[N];
	}
}