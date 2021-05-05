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
		
		while(!que.isEmpty()) {//ť�� ����� ������
			int node = que.poll();//ť�� ù��° ������ ����
			for(int i=1; i<=n ;i++) {
				if(graph[node][i]==1 && visit[i]==false) {//�������� ����Ǿ��ְ�, �湮�� �� ������
					que.add(i);//ť�� �ְ�
					visit[i] = true;//�湮 ǥ��
				}
			}
		}
	}
	
	public static void dfs(int start) {
		visit[start] = true;//�湮���� ǥ��
		for(int i=1; i<=n ;i++) {
			if(graph[start][i]==1 && visit[i]==false)//�������� ����Ǿ��ְ�, �湮�� �� ������
				dfs(i);//���
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
			graph[x][y]=1;//�Էµ� �����鳢��
			graph[y][x]=1;//������� ǥ��
		}
		
		for(int i=1; i<=n ;i++) {
			if(visit[i]==false) {//�湮���� ������
				count++;
				//bfs(i);
				dfs(i);
			}
		}
		System.out.println(count);
		sc.close();
	}

}
