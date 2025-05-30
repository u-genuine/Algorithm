import java.io.*;

class Solution {
    static char[][] charWords;
	static boolean[] visit;
	static int[][] diff;
	static int answer = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {

        charWords = new char[words.length + 1][begin.length()];
		visit = new boolean[words.length + 1];
		diff = new int[words.length + 1][words.length + 1];

		charWords[0] = begin.toCharArray();
		for(int i = 0; i < words.length; i++) {
			charWords[i + 1] = words[i].toCharArray();
		}

		for(int i = 0; i < charWords.length; i++) {
			for(int j = 0; j < charWords.length; j++) {
                int diffCount = 0;
				for(int k = 0; k < begin.length(); k++) {
					if(charWords[i][k] != charWords[j][k]) {
						diffCount++;
					}
				}
                diff[i][j] = diffCount;
                diff[j][i] = diffCount;
			}
		}

		visit[0] = true;
		DFS(target, 0, 0);

		if(answer == Integer.MAX_VALUE) {
			return 0;
		}
		return answer;
    }
    
    void DFS(String target, int depth, int index) {
        if(new String(charWords[index]).equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
		
		for(int i = 0; i < diff.length; i++ ) {
			if(!visit[i] && diff[index][i] == 1) {
                visit[i] = true;
				DFS(target, depth + 1, i);
                visit[i] = false;
			}
		}
	}
}