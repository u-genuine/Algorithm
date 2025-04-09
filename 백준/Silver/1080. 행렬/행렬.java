import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열

		int[][] matrixA = new int[N][M];
		int[][] matrixB = new int[N][M];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			String[] nums = st.nextToken().split("");
			for(int j = 0; j < M; j++){
				matrixA[i][j] = Integer.parseInt(nums[j]);
			}
		}

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			String[] nums = st.nextToken().split("");

			for(int j = 0; j < M; j++){
				matrixB[i][j] = Integer.parseInt(nums[j]);
			}
		}

		if(N < 3 || M < 3) {
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(matrixA[i][j] != matrixB[i][j]){
						System.out.println("-1");
						return;
					}
				}
			}
			System.out.println("0");
			return;
		}

		int count = 0;

		for(int i = 0; i < N - 2; i++){
			for(int j = 0; j < M - 2; j++){
				if(matrixA[i][j] != matrixB[i][j]){
					count++;
					for(int k = i; k < i + 3; k++){
						for(int l = j; l < j + 3; l++){
							if(matrixA[k][l] == 1) {
								matrixA[k][l] = 0;
							} else {
								matrixA[k][l] = 1;
							}
						}
					}
				}
			}
		}

		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(matrixA[i][j] != matrixB[i][j]){
					System.out.println("-1");
					return;
				}
			}
		}

		System.out.println(count);
	}
}
