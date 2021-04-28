package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[] visit;
	static int n;
	static int m;
	static int v;
	

	public static void clean() {
		Arrays.fill(visit, false);
	}
	
	public static void dfs(int v) {
		System.out.print(v+" ");
		visit[v]=true;
		for(int i=1 ;i<=n ;i++) {
			if(map[v][i]==1 && !visit[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v);
		visit[v]=true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+" ");
			for(int i=1; i<=n ;i++) {
				if(map[node][i]==1 && !visit[i]) {
					q.offer(i);
					visit[i]=true;
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m ;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			map[num1][num2] = 1;
			map[num2][num1] = 1;
		}
		
		dfs(v);
		System.out.println();
		clean();
		bfs(v);
		
		sc.close();
	}
}

