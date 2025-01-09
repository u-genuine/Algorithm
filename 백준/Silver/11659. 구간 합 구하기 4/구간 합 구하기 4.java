import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 숫자 개수
		int M = Integer.parseInt(st.nextToken()); // 질의 개수

		long[] S = new long[N+1]; // 1번째 인덱스부터 시작

		st = new StringTokenizer(br.readLine()); // 숫자 N개 입력한 줄 입력;

		S[0] = 0;

		for(int i = 1; i < N+1; i++){
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(S[end] - S[start-1]);
		}
	}
}
