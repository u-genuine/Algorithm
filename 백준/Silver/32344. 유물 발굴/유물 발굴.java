import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long R = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		List<List<Artifact>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			long r = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());

			if(list.size() <= num) {
				while(list.size() <= num) {
					list.add(new ArrayList<>());
				}
			}

			list.get(num).add(new Artifact(num, r, c));
		}

		long max = 0;
		long resultNum = 0;

		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).isEmpty()) continue;

			int count = list.get(i).size();
			Artifact cur = list.get(i).get(0);
			long minR = cur.r;
			long maxR = cur.r;
			long minC = cur.c;
			long maxC = cur.c;

			for(int j = 1; j < count; j++) {
				Artifact next = list.get(i).get(j);
				minR = Math.min(minR, next.r);
				maxR = Math.max(maxR, next.r);
				minC = Math.min(minC, next.c);
				maxC = Math.max(maxC, next.c);
			}

			long temp = (maxR - minR + 1) * (maxC - minC + 1);
			if(max < temp) {
				max = temp;
				resultNum = cur.num;
			}
		}

		System.out.println(resultNum + " " + max);
	}
}

class Artifact {
	int num;
	long r;
	long c;

	public Artifact(int num, long r, long c) {
		this.num = num;
		this.r = r;
		this.c = c;
	}
}