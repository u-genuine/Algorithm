/*
D[N] (길이가 2xN인 직사각형이 2x1, 1x2 타일을 붙일 수 있는 경우의 수)
D[1] = 1
D[2] = 2
for(i -> 3 ~ N){
	D[i] = D[i-1] + D[i-2]
	나온 결과 10007 나눈 나머지 연산
}
D[N] 값 출력

 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long D[] = new long[1001];

		D[1] = 1; // N = 1 일때 타일 채우는 경우의 수
		D[2] = 2; // N = 2 일때 타일 채우는 경우의 수

		for(int i = 3; i <= N; i++){
			D[i] = (D[i-1] + D[i-2]) % 10007;
		}
		System.out.println(D[N]);
	}
}
