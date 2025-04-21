import java.io.*;
import java.util.*;

class Main {
	static int cash;
	static int[] graph = new int[14];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cash = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}

		int junhyun = BNP();
		int seongmin = TIMING();
		if(junhyun > seongmin) {
			System.out.println("BNP");
		} else if(junhyun < seongmin) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}

	static int BNP() {
		int remain = cash;
		int count = 0;
		for(int i = 0; i < 14; i++) {
			if(remain >= graph[i]) {
				count += remain / graph[i] ;
				remain -= count * graph[i];
			}
		}
		return remain + count * graph[13];
	}

	static int TIMING(){
		int remain = cash;
		int count = 0;
		int up = 0;
		int down = 0;

		for(int i = 1; i < 14; i++) {
			if(graph[i-1] < graph[i]){
				up++;
				down = 0;
			} else if (graph[i-1] > graph[i]){
				down++;
				up = 0;
			}

			if(up == 3) {
				remain += count * graph[i];
				count = 0;
			}

			if(down == 3) {
				if(remain >= graph[i]) {
					count += remain / graph[i];
					remain -= count * graph[i];
				}
			}
		}
		return remain + count*graph[13];
	}
}
