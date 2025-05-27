import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] segment = {
		{true, true, true, true, true, true, false}, // 0
		{false, true, true, false, false, false, false}, // 1
		{true, true, false, true, true, false, true}, // 2
		{true, true, true, true, false, false, true}, // 3
		{false, true, true, false, false, true, true}, // 4
		{true, false, true, true, false, true, true}, // 5
		{true, false, true, true, true, true, true}, // 6
		{true, true, true, false, false, false, false}, // 7
		{true, true, true, true, true, true, true}, // 8
		{true, true, true, true, false, true, true}, // 9
	};

	static int N, K, P, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[] xArr = new int[K];
		int tempX = X;
		for(int i = K-1; i >= 0; i--) {
			xArr[i] = tempX % 10;
			tempX /= 10;
		}

		int count = 0;
		for(int i = 1; i <= N; i++) { //  1 ~ N까지 바꿀 수 있는 숫자 개수
			if(i == X) { // 자기 자신 제외
				continue;
			}

			int tempI = i;
			int[] targetArr = new int[K];
			for(int j = K-1; j >= 0; j--) {
				targetArr[j] = tempI % 10;
				tempI /= 10;
			}

			int total = 0;
			for(int j = 0; j < K; j++) { // 각 자릿수
				for(int k = 0; k < 7; k++) { // 각 세그먼트
					if(segment[xArr[j]][k] != segment[targetArr[j]][k]) {
						total++;
					}
				}
			}
			if(total > P) {
				continue;
			}

			count++;
		}

		System.out.println(count);
	}
}
