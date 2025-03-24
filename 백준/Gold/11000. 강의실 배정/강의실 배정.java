import java.util.*;
import java.io.*;
class Main {
	static class Lecture {
		int start, end;

		Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Lecture[] lectures = new Lecture[N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			lectures[i] = new Lecture(start, end);
		}

		Arrays.sort(lectures, (o1, o2) -> {
			if( o1.start == o2.start) {
				return o1.end - o2.end;
			}
			return o1.start - o2.start;
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lectures[0].end);

		for(int i = 1; i < N; i++) {
			if(lectures[i].start >= pq.peek()){
				pq.poll();
			}
			pq.add(lectures[i].end);
		}

		System.out.println(pq.size());
	}
}