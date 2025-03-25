import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Integer> positive = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> negative = new PriorityQueue<>();

		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num > 0) {
				positive.add(num);
			} else {
				negative.add(num);
			}
		}

		int sum = 0;
        
		while(positive.size() >= 2) {
			int n1 = positive.poll();
            int n2 = positive.poll();
            if(n1 == 1 || n2 == 1){
                sum += n1 + n2;
            } else {
                sum += n1 * n2;
            }
		}
        
        if(!positive.isEmpty()){
            sum += positive.poll();
        }

		while(negative.size() >= 2) {
			int n1 = negative.poll();
            int n2 = negative.poll();
            sum += n1 * n2;
		}
        
        if(!negative.isEmpty()){
            sum += negative.poll();
        }

		System.out.println(sum);
	}
}