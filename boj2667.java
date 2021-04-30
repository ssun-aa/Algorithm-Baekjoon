package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Home{
	int x;
	int y;
	public Home(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class boj2667 {
	
	static private int n;
	static private int map[][];
	static private boolean visit[][];//true:방문, false:방문 전 
	static private int count=0;
	static private int countArr[]= new int [25*25/2+1];//지도의 크기가 최대 25, 한칸 건너 한칸에 집이 존재할 경우 최대의 수
	static private int group=0;
	static private int dx[]= {-1,0,1,0};
	static private int dy[]= {0,-1,0,1};
	
	public static void bfs(int x, int y) {
		Queue<Home> que = new LinkedList<Home>();
		
		que.add(new Home(x,y));//해당 집을 큐에 삽입
		visit[x][y] = true;//해당 집 방문 함
		
		while(!que.isEmpty()) {//큐가 비어질 때 까지
			Home h = que.poll();//큐의 첫번째 원소를 꺼냄
			for(int i=0; i<4; i++) {
				
				int nextX = h.x+dx[i];//다음으로 이동할 집
				int nextY = h.y+dy[i];//위,왼,아래,오른의 순서임
				
				if(nextX<0 || nextY<0 || nextX>=n || nextY>=n)//미로내의 집을 벗어나는 경우
					continue;
				if(visit[nextX][nextY])//방문 했던 집이면
					continue;
				if(map[nextX][nextY]==0)//집이 없으면
					continue;
				
				que.add(new Home(nextX, nextY));//위의 3가지 경우가 아니라면 큐에 다음 위치를 입력
				visit[nextX][nextY] = true;//방문 함으로 표시
				count++;//집 개수 증가
			}
		}
	}
	
	public static void dfs(int x, int y) {
		
		visit[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];//다음으로 이동할 집
			int nextY = y + dy[i];//위,왼,아래,오른의 순서임
			
			if(nextX<0 || nextY<0 || nextX>=n || nextY>=n)//미로내의 집을 벗어나는 경우
				continue;
			if(visit[nextX][nextY])//방문 했던 집이면
				continue;
			if(map[nextX][nextY]==0)//집이 없으면
				continue;
			
			dfs(nextX,nextY);//재귀
			count++;//집 개수 증가
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		
		sc.nextLine();//줄바꿈 주의!!
		
		for(int i=0; i<n; i++) {
			String line = sc.nextLine();//String 타입으로 입력받아서
			for(int j=0; j<n; j++) {
				map[i][j] = line.charAt(j)-'0';//char타입의 한 글자로 쪼개 문자 '0'을 빼면 숫자로 변경가능
			}
		}
				
		for(int i=0; i<n; i++) {//미로 전체 탐색
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && visit[i][j]==false) {//집이 있고 방문 전이라면
					count=1;
					dfs(i,j);
					//bfs(i,j);
					countArr[group++]=count;//집 개수 저장
				}
			}
		}
		
		Arrays.sort(countArr,0,group);//단지 내의 집 개수가 저장된 배열을 0~단지수 만큼만 부분 오름차순 정렬
		
		System.out.println(group);//단지 수 출력
		for(int i=0; i<group; i++)
			System.out.println(countArr[i]);//단지 내의 집 개수 출력
		
		sc.close();
	}

}
