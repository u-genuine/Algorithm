import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
투 포인터로 접근

N(재료의 개수), M(갑옷이 되는 번호) 저장

for (N만큼 반복) {
	재료 배열 저장
}
재료 배열 정렬

while(i < j){
	if(재료 합 < M)
		작은 번호 재료를 한 칸 위로 변경
	else if(재료 합 > M)
		큰 번호 재료를 한칸 아래로 변경
	else
		count++. 양쪽 index 모두 변경
}

 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int count = 0;
		int i = 0;
		int j = N-1;

		while(i < j){
			if(A[i] + A[j] > M) j--;
			else if(A[i] + A[j] < M) i++;
			else {
				count++;
				i++;
				j--;
			}
		}

		System.out.println(count);
	}
}
