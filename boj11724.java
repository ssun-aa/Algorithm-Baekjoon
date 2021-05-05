package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj11724 {

	static int n, m;
	static int graph[][];
	static boolean visit[];
	
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		visit[start] = true;
		
		while(!que.isEmpty()) {//큐가 비어질 때까지
			int node = que.poll();//큐의 첫번째 정점을 꺼냄
			for(int i=1; i<=n ;i++) {
				if(graph[node][i]==1 && visit[i]==false) {//정점끼리 연결되어있고, 방문한 적 없으면
					que.add(i);//큐에 넣고
					visit[i] = true;//방문 표시
				}
			}
		}
	}
	
	public static void dfs(int start) {
		visit[start] = true;//방문으로 표시
		for(int i=1; i<=n ;i++) {
			if(graph[start][i]==1 && visit[i]==false)//정점끼리 연결되어있고, 방문한 적 없으면
				dfs(i);//재귀
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=0;
		
		n = sc.nextInt();
		m = sc.nextInt();
	
		graph = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m ;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y]=1;//입력된 정점들끼리
			graph[y][x]=1;//연결됨을 표시
		}
		
		for(int i=1; i<=n ;i++) {
			if(visit[i]==false) {//방문한적 없으면
				count++;
				//bfs(i);
				dfs(i);
			}
		}
		System.out.println(count);
		sc.close();
	}

}
