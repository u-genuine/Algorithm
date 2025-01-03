import java.util.Scanner;

/*
answer(정답 변수)
들어온 데이터를 "-" 기호 기준으로 split()

for(나눠진 데이터 개수만큼 반복){
	결괏값 = mySum()
	if(가장 앞 데이터일 때) answer에 결괏값 더하기
	else answer에 결괏값 빼기
}
answer 출력
mySum() 함수 구현 { // 현재 String에 있는 수를 모두 더하는 함수
	들어온 String을 "+"를 기준으로 split()
	for(나눠진 데이터 개수만큼 반복){
		String을 Integer 형으로 변환해서 리턴값에 더하기
	}
	전체 합 리턴
}
 */

public class Main {
	static int answer = 0;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String example = sc.nextLine();
		String[] str = example.split("-");

		for(int i = 0; i < str.length; i++){
			int temp = mySum(str[i]);

			if(i == 0) answer += temp;
			else answer -= temp;
		}

		System.out.println(answer);
	}

	private static int mySum(String a){
		int sum = 0;
		String[] temp = a.split("\\+");

		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
