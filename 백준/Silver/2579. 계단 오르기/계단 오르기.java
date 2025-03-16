import java.util.*;

class Main {
	static int[] point;
	static int[] maxPoint;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int stairs = sc.nextInt();
		point = new int[stairs + 1];
		maxPoint = new int[stairs + 1];

		Arrays.fill(maxPoint, -1);

		for (int i = 1; i <= stairs; i++) {
			point[i] = sc.nextInt();
		}

		maxPoint[0] = 0;
		maxPoint[1] = point[1];
        
		if(stairs >= 2) {
			maxPoint[2] = point[1]+point[2];
		}

		System.out.println(recur(stairs));
	}

	public static int recur(int n) {
		if (n > 2 && maxPoint[n] < 0) {
			maxPoint[n] = Math.max(recur(n - 2), recur(n - 3) + point[n - 1]) + point[n];
		}
		return maxPoint[n];
	}
}