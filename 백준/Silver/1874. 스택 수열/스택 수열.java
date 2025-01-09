import java.util.Scanner;
import java.util.Stack;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 숫자 개수
		int[] A = new int[n]; // n개 수열 저장 배열

		for(int i = 0; i < n; i++){
			A[i] = sc.nextInt(); // 수열 저장
		}

		Stack<Integer> stack = new Stack<>(); // 스택 생성
		int num = 1; // 스택에 들어갈 수

		boolean result = true;

		StringBuffer bf = new StringBuffer(); // +- 저장

		for(int i = 0; i < A.length; i++){ // 수열 길이만큼 반복
			int su = A[i]; // 수열에서 현재 숫자
			if(su >= num){ // 수열의 숫자가 num이랑 같거나 크면
				while(su >= num){ // 수열의 수보다 num이 커지기 전까지
					stack.push(num++);  // 스택에 num 넣기
					bf.append("+\n"); // + 저장
				} // 스택의 수보다 num이 커지면
				stack.pop(); // 스택의 top이 su랑 같으니까 pop()
				bf.append("-\n"); // - 저장
			}else{ // 수열의 숫자가 num보다 작으면
				int temp = stack.pop(); // 스택의 top 확인
				if(temp > su) { // 스택의 top이 수열의 숫자보다 크면
					System.out.println("NO"); // 실패
					result = false;
					break;
				}else{ // 스택의 top이 수열의 숫자와 같은 경우임 작을 순 없어
					bf.append("-\n"); // - 저장
				}
			}
		}
		if(result)
			System.out.println(bf.toString());


	}
}
