import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] score = new int[N];

		long max = 0;
		long sum = 0;

		for (int i = 0; i < N; i++){
			score[i] = sc.nextInt();
			sum += score[i];

			if(max < score[i]) max = score[i];
		}

		System.out.println(sum*100.0/max/N);
	}
}
