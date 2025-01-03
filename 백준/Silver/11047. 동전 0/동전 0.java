import java.util.Scanner;

/*
N(동전 종류 수) K(만들 가격)
A(동전 데이터 배열)

배열 선언 for(N 만큼 반복){
	A 배열 저장
}

// 가치가 큰 동전부터 선택해야 개수를 최소로 구성할 수 있음
for(N 만큼 반복 -> N-1 ~ 0 으로 역순으로 반복){
	동전 개수 += 목표 금액 / 현재 동전 가치
	목표 금액 = 목표 금액 % 현재 동전 가치
}
 */

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] A = new int[N];

		for(int i = 0; i < N; i++){
			A[i] = sc.nextInt();
		}

		int count = 0;

		for(int i = N-1; i >= 0; i--){
			count += K / A[i];
			K = K % A[i];
		}

		System.out.println(count);
	}
}
