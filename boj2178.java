package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Dot{
	int x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class boj2178 {
	static int[][] maze;
	static boolean[][] visit;
	static int n;
	static int m;
	static int[] dx = {-1, 0, 1 ,0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void search(int x, int y) {
		Queue<Dot> que = new LinkedList<Dot>();
		que.add(new Dot(x,y));
		visit[x][y] = true;
		
		while(!que.isEmpty()) {
			Dot d = que.poll();
			for(int i=0; i<4 ;i++) {
				int nextX = d.x+dx[i];
				int nextY = d.y+dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;
				if(visit[nextX][nextY])//방문 했던 점이면
					continue;
				if(maze[nextX][nextY]==0)//이동할 수 없는 점이면
					continue;
				
				que.add(new Dot(nextX, nextY));
				visit[nextX][nextY]=true;
				maze[nextX][nextY] = maze[d.x][d.y]+1;
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		sc.nextLine();//줄바꿈 주의!!
		
		maze = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n ;i++) {
			String num = sc.nextLine();
			for(int j=0; j<m ;j++) {
				maze[i][j] = num.charAt(j)-'0';
			}
			
		}
		search(0,0);
		System.out.println(maze[n-1][m-1]);
		sc.close();
	}
}

