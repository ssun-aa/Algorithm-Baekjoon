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
		
		que.add(computer);//�ش� ��ǻ�͸� ť�� ����
		visit[computer]=true;//�ش� ��ǻ�� �湮��
		
		while(!que.isEmpty()) {//ť�� ����� �� ����
			int com = que.poll();//ť�� ù��° ���Ҹ� ����
			for(int i=1; i<=n ;i++) {//��� ��ǻ�� ������ŭ
				if(map[com][i]==1 && visit[i]==false) {//�ش� ��ǻ�Ϳ� ����Ǿ��ְ�, �湮 ���̶��
					que.add(i);//�ش� ��ǻ�͸� ť�� ����
					visit[i]=true;//�ش� ��ǻ�� �湮��
					count++;//��ǻ�� ���� ����
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();//�ٹٲ� ����!!
		int m = sc.nextInt();
		sc.nextLine();//�ٹٲ� ����!!
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m ;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sc.nextLine();//�ٹٲ� ����!!
			map[x][y]=1;//�Է¹��� ��ǻ�͵鳢��
			map[y][x]=1;//������� ǥ��
		}
		bfs(1);
		
		System.out.println(count);
		
		sc.close();

	}

}
