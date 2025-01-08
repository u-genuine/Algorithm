/*
D(점화식 배열 -> i ~ 퇴사일까지 벌 수 있는 최대 수입 저장)

N(퇴사까지 남은 날짜)

T (상담에 걸리는 일 수 저장 배열)
P (상담 완료시 받는 수입 저장 배열)

for(N만큼 반복) {
	T, P 배열 저장
}

for(i -> N ~ 1까지 반복){
	if(i + T[i] > N + 1) // i번쨰 상담을 퇴사일까지 끝낼 수 없을 때
		D[i] = i + 1일 ~ 퇴사일까지 벌 수 있는 최대수입과 동일
	else{ // i번째 상담을 퇴사일까지 끝낼 수 있을 때
		D[i] = MAX(i + 1일 ~ 퇴사일까지 벌 수 있는 최대 수입과
					i번째 상담 비용 + i번째 상담이 끝난 다음 날부터 퇴사일까지 최대 수입)
	}
}
D[1] 출력 (1일부터 퇴사일까지 벌 수 있는 최대수입)
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] D = new int[N+2];
		int[] T = new int[N+1];
		int[] P = new int[N+1];

		for (int i = 1; i <= N; i++){
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		for(int i = N; i > 0; i--){
			if(i + T[i] > N + 1) {
				D[i] = D[i+1];
			} else {
				D[i] = Math.max(D[i+1], P[i] + D[i+T[i]]);
			}
		}

		System.out.println(D[1]);
	}
}
