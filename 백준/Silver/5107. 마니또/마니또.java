import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int level = 1;

		while (true) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;

			if (N == 0)
				break;
			ArrayList<String> person = new ArrayList<>();
			HashMap<String, String> map = new HashMap();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String giver = st.nextToken();
				String receiver = st.nextToken();

				map.put(giver, receiver);
				person.add(giver);
			}

			for (String giver : person) {
				String receiver = map.get(giver);

				while (true) {
					receiver = map.get(receiver);

					if (receiver == null) {
						break;
					} else if (receiver.equals(giver)) {
						map.remove(receiver);
						count++;
					}
				}
			}
			
			System.out.println(level + " " + count);
			level++;
		}
	}
}