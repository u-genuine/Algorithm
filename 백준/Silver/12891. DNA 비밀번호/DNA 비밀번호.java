import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		st = new StringTokenizer(br.readLine());
		int minA = Integer.parseInt(st.nextToken());
		int minC = Integer.parseInt(st.nextToken());
		int minG = Integer.parseInt(st.nextToken());
		int minT = Integer.parseInt(st.nextToken());

		int countA = 0;
		int countC = 0;
		int countG = 0;
		int countT = 0;

		int idx1 = 0, idx2 = 0;
		int result = 0;

		while(idx2 < P){
			char targetChar = str.charAt(idx2);
			if(targetChar == 'A') countA++;
			else if(targetChar == 'C') countC++;
			else if(targetChar == 'G') countG++;
			else if(targetChar == 'T') countT++;
			idx2++;
		}

		if(countA >= minA &&
			countC >= minC &&
			countG >= minG &&
			countT >= minT) {
				result++;
		}

		while(idx2 < S) {
			char removeChar = str.charAt(idx1);
			if(removeChar == 'A') countA--;
			else if(removeChar == 'C') countC--;
			else if(removeChar == 'G') countG--;
			else if(removeChar == 'T') countT--;

			char addChar = str.charAt(idx2);
			if(addChar == 'A') countA++;
			else if(addChar == 'C') countC++;
			else if(addChar == 'G') countG++;
			else if(addChar == 'T') countT++;
			idx1++;
			idx2++;

			if(countA >= minA &&
				countC >= minC &&
				countG >= minG &&
				countT >= minT) {
					result++;
			}
		}

		System.out.println(result);
	}
}