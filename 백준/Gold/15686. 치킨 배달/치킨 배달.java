import java.io.*;
import java.util.*;

class Main {
	static int N; // 도시 크기
	static int M; // 남길 치킨집 수
	static int[][] chickenDistances; // [집][치킨집] 거리
	static int minTotalDistances = Integer.MAX_VALUE; // 도시 최소 치킨거리

	static List<int[]> houses = new ArrayList<>(); // 집 위치 목록
	static List<int[]> chickenShops = new ArrayList<>(); // 치킨 위치 목록
	static int houseCount = 0;
	static int chickenShopCount = 0;

	static boolean[] isChickenShopSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());

				if(num == 1) {
					houses.add(new int[]{i, j});
					houseCount++;
				} else if(num == 2) {
					chickenShops.add(new int[]{i, j});
					chickenShopCount++;
				}
			}
		}

		isChickenShopSelected = new boolean[chickenShopCount];
		chickenDistances = new int[houseCount][chickenShopCount];

		// 각 집에서 각 치킨집까지 거리 계산
		for(int i = 0; i < houseCount; i++) {
			for(int j = 0; j < chickenShopCount; j++) {
				int dx = Math.abs(houses.get(i)[0] - chickenShops.get(j)[0]);
				int dy = Math.abs(houses.get(i)[1] - chickenShops.get(j)[1]);
				chickenDistances[i][j] = dx + dy;
			}
		}

		DFS(0, 0);
		System.out.println(minTotalDistances);
	}

	static void DFS(int index, int selectedCount) {
		if(index == chickenShopCount) {
			if(selectedCount == M){
				int totalDistance = 0;

				// 각 집마다 가장 가까운 치킨집과의 거리 계산
				for(int i = 0; i < houseCount; i++) { 
					int shortestDistance = 2 * N;

					// 선택된 치킨집 중 가장 가까운 거리 찾기
					for(int j = 0; j < chickenShopCount; j++) {
						if(isChickenShopSelected[j]){
							shortestDistance = Math.min(shortestDistance, chickenDistances[i][j]);
						}
					}
					totalDistance += shortestDistance;
				}
				
				// 도시 치킨거리 최솟값 갱신
				minTotalDistances = Math.min(minTotalDistances, totalDistance);
			}
			return;
		}

		isChickenShopSelected[index] = true;
		DFS(index + 1, selectedCount + 1);

		isChickenShopSelected[index] = false;
		DFS(index + 1, selectedCount);
	}
}