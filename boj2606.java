package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2606 {

	static int n;
	static int map[][];
	static boolean visit[];
	static int count=0;
	
	public static void bfs(int computer) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(computer);//해당 컴퓨터를 큐에 삽입
		visit[computer]=true;//해당 컴퓨터 방문함
		
		while(!que.isEmpty()) {//큐가 비어질 때 까지
			int com = que.poll();//큐의 첫번째 원소를 꺼냄
			for(int i=1; i<=n ;i++) {//모든 컴퓨터 개수만큼
				if(map[com][i]==1 && visit[i]==false) {//해당 컴퓨터와 연결되어있고, 방문 전이라면
					que.add(i);//해당 컴퓨터를 큐에 삽입
					visit[i]=true;//해당 컴퓨터 방문함
					count++;//컴퓨터 개수 증가
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();//줄바꿈 주의!!
		int m = sc.nextInt();
		sc.nextLine();//줄바꿈 주의!!
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m ;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sc.nextLine();//줄바꿈 주의!!
			map[x][y]=1;//입력받은 컴퓨터들끼리
			map[y][x]=1;//연결됨을 표현
		}
		bfs(1);
		
		System.out.println(count);
		
		sc.close();

	}

}
