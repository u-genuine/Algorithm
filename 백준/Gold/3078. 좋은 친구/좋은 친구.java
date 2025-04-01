import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long pairs = 0;

		int[] nameLength = new int[N];
		int[] lengthCount = new int[21];

		for(int i = 0; i < N; i++) {
			nameLength[i] = br.readLine().length();
			if(i <= K) {
				lengthCount[nameLength[i]]++;
			}
		}

		pairs += --lengthCount[nameLength[0]];

		for(int i = 1; i < N; i++){
			if(i + K < N){
				lengthCount[nameLength[i+K]]++;
			}
			pairs += --lengthCount[nameLength[i]];
		}

		System.out.println(pairs);
	}
}