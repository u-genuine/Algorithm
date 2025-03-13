import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++){
			int current = Integer.parseInt(st.nextToken());
			map.put(current, map.getOrDefault(current, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++){
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
		}
        
        System.out.println(sb);
	}
}
