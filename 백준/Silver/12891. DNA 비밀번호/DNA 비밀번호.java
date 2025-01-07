import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
S(문자열 크기) P(부분 문자열 크기)
A(DNA 문자열 데이터)
checkArr(비밀번호 체크 배열)

myArr(현재 상태 배열)

checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
P 범위 (0 ~ P-1)만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단.
for(i를 P에서 S까지 반복) {
	j 선언 (i-P)
	Add(A[i]);
	Remove(A[j]):
}

 */

public class Main {
	static int myArr [] = new int[4]; // 현재 부분문자열에서 A, C, G, T 개수
	static int checkArr [] = new int[4]; // 만족해야 할 A, C, G, T 개수
	static int checkSecret = 0; // 몇 개의 문자를 만족하는지 카운트

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이 (윈도우 크기)
		int Result = 0; // 비밀번호로 쓸 수 있는 부분문자열 카운트 (정답)

		char A[] = new char[S]; // 전체 문자열 담을 배열

		A = bf.readLine().toCharArray(); // 문자열 읽어와서 char 배열로 A에 저장 
        
		st = new StringTokenizer(bf.readLine()); // 만족해야 할 A, C, G, T 개수 읽어오기
        
		for(int i = 0; i < 4; i++){
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) // 0이면 이미 그 문자는 개수 만족
				checkSecret++; // checkSecret이 4가 되면 비밀번호로 쓸 수 있음
		}

		for(int i = 0; i < P; i++){ // 부분문자열 처음 받을때 셋팅
			Add(A[i]);
		}

		if(checkSecret == 4) Result++;

		// 슬라이딩 윈도우
		for(int i = P; i < S; i++){
			int j = i-P; // 윈도우 시작 인덱스
			Add(A[i]);
			Remove(A[j]);

			if(checkSecret == 4) Result++;
		}

		System.out.println(Result);
		bf.close();

	}

	public static void Add(char c){
		switch(c){
			case 'A':
				myArr[0]++;
				if(checkArr[0] == myArr[0]) checkSecret++;
				break;
			case 'C':
				myArr[1]++;
				if(checkArr[1] == myArr[1]) checkSecret++;
				break;
			case 'G':
				myArr[2]++;
				if(checkArr[2] == myArr[2]) checkSecret++;
				break;
			case 'T':
				myArr[3]++;
				if(checkArr[3] == myArr[3]) checkSecret++;
				break;
		}
	}

	public static void Remove(char c){
		switch(c){
			case 'A':
				if(checkArr[0] == myArr[0]) checkSecret--;
				myArr[0]--;
				break;
			case 'C':
				if(checkArr[1] == myArr[1]) checkSecret--;
				myArr[1]--;
				break;
			case 'G':
				if(checkArr[2] == myArr[2]) checkSecret--;
				myArr[2]--;
				break;
			case 'T':
				if(checkArr[3] == myArr[3]) checkSecret--;
				myArr[3]--;
				break;
		}
	}
}
