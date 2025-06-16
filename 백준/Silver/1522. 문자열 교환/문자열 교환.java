import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] strArr = str.split("");
		int aCount = 0;
		for(String one : strArr) {
			if(one.equals("a"))
				aCount++;
		}

		int result = strArr.length;
		for(int i = 0; i < strArr.length; i++) {
			int temp = 0;
			for(int j = i; j < i + aCount; j++) {
				int tempJ = j;
				if(tempJ >= strArr.length) {
					tempJ -= strArr.length;
				}
				if(strArr[tempJ].equals("b")) {
					temp++;
				}
			}

			result = Math.min(result, temp);
		}

		System.out.println(result);
	}
}