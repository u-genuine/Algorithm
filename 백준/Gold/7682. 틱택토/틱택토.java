import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] bingo = {
			{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로
			{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로
			{0, 4, 8}, {2, 4, 6}             // 대각선
		};

		StringBuilder sb = new StringBuilder();

		while(true){
			String line = br.readLine();

			if(line.equals("end")) {
				break;
			}

			String[] board = new String[9];
			board = line.split("");

			Set<Integer> xIndex = new HashSet<>();
			Set<Integer> oIndex = new HashSet<>();

			for(int i = 0; i < 9; i++) {
				if(board[i].equals("X")) {
					xIndex.add(i);
				}else if(board[i].equals("O")) {
					oIndex.add(i);
				}
			}

			// x 보다 o가 많은 경우
			if(xIndex.size() < oIndex.size() || xIndex.size() - oIndex.size() > 1) {
				sb.append("invalid");
				sb.append("\n");
				continue;
			}

			// 빙고 상태에서 상대가 또 두는 경우
			boolean finish = false;
			boolean hasBingo = false;

			for(int[] oneBingo : bingo) {
				boolean xHasBingo = true;
				for(int one : oneBingo) {
					if(!xIndex.contains(one)) {
						xHasBingo = false;
						break;
					}
				}

				boolean oHasBingo = true;
				for(int one : oneBingo) {
					if(!oIndex.contains(one)) {
						oHasBingo = false;
						break;
					}
				}

				if(xHasBingo || oHasBingo) {
					hasBingo = true;
				}

				if(xHasBingo && xIndex.size() <= oIndex.size()) {
					sb.append("invalid");
					sb.append("\n");
					finish = true;
					break;
				} else if(oHasBingo && xIndex.size() > oIndex.size()) {
					sb.append("invalid");
					sb.append("\n");
					finish = true;
					break;
				}
			}

			if(finish) {
				continue;
			}

			// 게임이 진행중인 경우
			if(!hasBingo && xIndex.size() + oIndex.size() < 9 && xIndex.size() - oIndex.size() <= 1) {
				sb.append("invalid");
				sb.append("\n");
				continue;
			}

			sb.append("valid");
			sb.append("\n");
		}

		System.out.println(sb);
	}
}