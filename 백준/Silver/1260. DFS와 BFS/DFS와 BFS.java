/*
N(노드 개수) M(에지 개수) Start(시작점)
A(그래프 데이터 저장 인접 리스트) visited(방문 기록 저장 배열)

for(N 만큼 반복){
	A 인접리스트의 각 ArrayList 초기화
}

for(M 만큼 반복){
	A 인접리스트에 그래프 데이터 저장
}

visited 배열 초기화
DFS(Start) 실행하기
visited 배열 초기화
BFS(Start) 실행하기

DFS{
	현재 노드 출력하기
	visited 배열에 현재 노드 방문 기록하기
	현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
}

BFS{
	큐 자료구조에 시작 노드 삽입하기 (add 연산)
	visited 배열에 현재 노드 방문 기록하기
	while(큐가 비어 있을 때까지){
		큐에서 노드 데이터 가져오기 (poll 연산)
		가져온 노드 출력하기
		현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입(add 연산) 하고 방문 배열에 기록하기
	}
}
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean visited[];
	static ArrayList<Integer>A[];

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();

		A = new ArrayList[N+1];

		for(int i = 1; i < N+1; i++){
			A[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i<M; i++){
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}

		for(int i = 1; i < N+1; i++){
			Collections.sort(A[i]);
		}

		visited = new boolean[N+1];
		DFS(start);
		System.out.println();

		visited = new boolean[N+1];
		BFS(start);
	}
	private static void BFS(int Node){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;

		while(!queue.isEmpty()){
			int now_Node = queue.poll();
			System.out.print(now_Node + " ");
			for(int i:A[now_Node]){
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
		}


	}

	private static void DFS(int Node){
		System.out.print(Node + " ");
		visited[Node] = true;
		for(int i : A[Node]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}
}
