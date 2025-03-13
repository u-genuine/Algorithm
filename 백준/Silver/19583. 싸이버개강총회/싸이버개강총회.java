import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String start = st.nextToken();
		String end = st.nextToken();
		String endStreaming = st.nextToken();

		HashSet<String> before = new HashSet<>();
		HashSet<String> after = new HashSet<>();
		HashSet<String> nicknames = new HashSet<>();

		String line;
		while((line = br.readLine()) != null) {
			String[] arr = line.split(" ");
			String time = arr[0];
			String nickname = arr[1];

			nicknames.add(nickname);

			if (start.compareTo(time) >= 0)
				before.add(nickname);
			else if (end.compareTo(time) <= 0 && endStreaming.compareTo(time) >= 0)
				after.add(nickname);
		}
			int count = 0;
			for(String one : nicknames) {
				if(before.contains(one) && after.contains(one))
					count++;
			}
			System.out.println(count);
	}
}
