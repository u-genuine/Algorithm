import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			int num;
			switch(oper) {
				case "add" :
					num = Integer.parseInt(st.nextToken());
					set.add(num);
					break;
				case "remove" :
					num = Integer.parseInt(st.nextToken());
					if(set.contains(num)) {
						set.remove(num);
					}
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					if(set.contains(num)) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					if(set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}
					break;
				case "all" :
					for(int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
				default:
					set.clear();
					break;
			}
		}

		System.out.println(sb);
	}
}