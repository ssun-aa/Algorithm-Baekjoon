package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {

	static int visit[] = new int[100001];//방문 및 시간 체크
	static int k;
	public static void bfs(int num) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(num);//수빈의 위치 삽입
		visit[num] = 1;//방문함, 시간 1로 초기화
		
		while(!que.isEmpty()) {//큐가 비어질 때까지
			int x = que.poll();
			
			for(int i=0; i<3; i++) {
				int next;//수빈의 다음 위치
				
				if(i == 0)
					next = x - 1;//뒤로 한칸
				else if(i == 1)
					next = x + 1;//앞으로 한칸
				else
					next = x * 2;//순간이동
				
				if(next == k) {//다음위치가 동생위치와 같다면
					System.out.println(visit[x]);//걸린 시간 출력
					return;
				}
				if(next>=0 && next<=100000 && visit[next] == 0) {
					//다음 위치가 범위 내이고 방문한적 없다면
					que.add(next);//큐에 다음 위치 삽입
					visit[next] = visit[x] + 1;//시간 1초 증가 
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//수빈의 위치
		k = sc.nextInt();//동생 위치
		
		if(n == k)//처음에 수빈과 동생의 위치가 같을경우
			System.out.println(0);
		else
			bfs(n);//수빈의 위치
		
		sc.close();
	}

}
