import java.util.*;

class Main {
	static Integer[] dp;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		dp = new Integer[size];
		arr = new int[size];

		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i = 0; i < size; i++) {
			max = Math.max(max, recur(i));
		}
		
		System.out.println(max);
	}

	public static int recur(int idx) {
		if(dp[idx] == null){
			dp[idx] = 1;

			for(int i = idx-1; i >= 0; i--) {
				if(arr[i] < arr[idx])
					dp[idx] = Math.max(dp[idx], recur(i)+1);
			}
		}

		return dp[idx];
	}
}