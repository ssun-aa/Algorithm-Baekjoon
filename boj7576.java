package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tomato{
	int x;
	int y;
	int day;
	
	public tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
public class boj7576 {
	static int n, m;
	static int box[][];
	static int dx[] = {-1, 0, 1, 0};//위,왼,아래,오른의 순서로
	static int dy[] = {0, -1, 0 ,1};//다음 토마토 위치 
	
	public static boolean checkTomato() {//익지 않은 토마토(=0)가 있을 경우 false반환
										//모두 익었을 경우(=1)에는 true 반환
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j]==0) {
					return false;
				}
			}		
		}
		return true;
	}
	public static void bfs() {
		Queue<tomato> que = new LinkedList<tomato>();
		int day = 0; //최소 일수 세는 변수
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 1)//이미 익은 토마토를 찾아서
					que.add(new tomato(i,j,0));//익은 토마토를 que에 더하여 bfs 실행
			}
		}
		
		while(!que.isEmpty()) {//큐가 비어질 때 까지
			tomato tom = que.poll();//큐의 첫번째 원소를 꺼냄
			day= tom.day;
			
			for(int i=0; i<4; i++) {
				int nextX = tom.x + dx[i];
				int nextY = tom.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) //박스 범위를 벗어나는 경우
					continue;
					
				if(box[nextX][nextY]!=0) //이미 익은 토마토일 경우
					continue;
				
				que.add(new tomato(nextX, nextY, day+1));//위의 경우를 제외하고서는 day+1하여 큐에 삽입
				box[nextX][nextY]=1;//익은 토마토로 표시
			}
		}
		if(checkTomato())
			System.out.println(day);//모든 토마토가 익은 경우 날짜 출력
		else
			System.out.println(-1);//익지 않는 토마토가 있는 경우 -1 출력
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		box = new int[n][m];
				
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		bfs();
		
		sc.close();
	}

}
