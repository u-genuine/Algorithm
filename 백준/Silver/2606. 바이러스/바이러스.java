import java.util.Scanner;

public class Main {
	static boolean[][] graph;
	static boolean[] visited;
	static int N, M;
	static int answer;

	public static void main(String[] args){
		// 입력 및 초기화
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		// 그래프 정보 입력
		int x, y;
		for(int i = 0; i < M; i++){
			x = sc.nextInt();
			y = sc.nextInt();

			graph[x][y] = true;
			graph[y][x] = true;
		}

		// DFS
		dfs(1);

		System.out.println(answer - 1); // 1번 컴퓨터 제외
		sc.close();
	}
    
     public static void dfs(int index){
		answer++;
		visited[index] = true;

		for (int i = 0; i < N+1; i++){
			if(!visited[i] && graph[index][i]){
				dfs(i);
			}
		}
	}

}
