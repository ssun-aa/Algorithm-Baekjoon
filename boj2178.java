package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Dot{//칸의 좌표를 의미함
	int x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class boj2178 {
	static int[][] maze;//미로
	static boolean[][] visit; //칸을 방문 했는지 안했는지
	static int n;
	static int m;
	static int[] dx = {-1, 0, 1 ,0};//x좌표로의 움직임
	static int[] dy = {0, -1, 0, 1};//y좌표로의 움직임;왼,아래,오른,위의 방향을 가짐
	
	public static void search(int x, int y) {
		Queue<Dot> que = new LinkedList<Dot>();
		que.add(new Dot(x,y));//해당 칸을 큐에 삽입
		visit[x][y] = true;//해당 칸 방문 함
		
		while(!que.isEmpty()) {//큐가 비어질 때 까지
			Dot d = que.poll();//큐의 첫번째 원소를 꺼냄
			for(int i=0; i<4 ;i++) {
				int nextX = d.x+dx[i];//다음으로 이동할 칸
				int nextY = d.y+dy[i];//왼,아래,오른,위의 순서임
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)//미로의 칸을 벗어나는 경우
					continue;
				if(visit[nextX][nextY])//방문 했던 점이면
					continue;
				if(maze[nextX][nextY]==0)//이동할 수 없는 점이면
					continue;
				
				que.add(new Dot(nextX, nextY));//위의 3가지 경우가 아니라면 큐에 다음 위치를 입력
				visit[nextX][nextY]=true;//방문 함
				maze[nextX][nextY] = maze[d.x][d.y]+1;//한번 지나온 칸의 수를 몇번째로 지나왔는지로 변경
													  //최소의 칸을 세기 위함
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
			String num = sc.nextLine();//String 타입으로 입력받아서
			for(int j=0; j<m ;j++) {
				maze[i][j] = num.charAt(j)-'0';//char타입의 한 글자로 쪼개 문자 '0'을 빼면 숫자로 변경가능
			}
			
		}
		
		search(0,0);
		System.out.println(maze[n-1][m-1]);
		
		sc.close();
	}
}

