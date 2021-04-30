package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Dot{//ĭ�� ��ǥ�� �ǹ���
	int x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class boj2178 {
	static int[][] maze;//�̷�
	static boolean[][] visit; //ĭ�� �湮 �ߴ��� ���ߴ���
	static int n;
	static int m;
	static int[] dx = {-1, 0, 1 ,0};//x��ǥ���� ������
	static int[] dy = {0, -1, 0, 1};//y��ǥ���� ������;��,�Ʒ�,����,���� ������ ����
	
	public static void search(int x, int y) {
		Queue<Dot> que = new LinkedList<Dot>();
		que.add(new Dot(x,y));//�ش� ĭ�� ť�� ����
		visit[x][y] = true;//�ش� ĭ �湮 ��
		
		while(!que.isEmpty()) {//ť�� ����� �� ����
			Dot d = que.poll();//ť�� ù��° ���Ҹ� ����
			for(int i=0; i<4 ;i++) {
				int nextX = d.x+dx[i];//�������� �̵��� ĭ
				int nextY = d.y+dy[i];//��,�Ʒ�,����,���� ������
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)//�̷��� ĭ�� ����� ���
					continue;
				if(visit[nextX][nextY])//�湮 �ߴ� ���̸�
					continue;
				if(maze[nextX][nextY]==0)//�̵��� �� ���� ���̸�
					continue;
				
				que.add(new Dot(nextX, nextY));//���� 3���� ��찡 �ƴ϶�� ť�� ���� ��ġ�� �Է�
				visit[nextX][nextY]=true;//�湮 ��
				maze[nextX][nextY] = maze[d.x][d.y]+1;//�ѹ� ������ ĭ�� ���� ���°�� �����Դ����� ����
													  //�ּ��� ĭ�� ���� ����
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		sc.nextLine();//�ٹٲ� ����!!
		
		maze = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n ;i++) {
			String num = sc.nextLine();//String Ÿ������ �Է¹޾Ƽ�
			for(int j=0; j<m ;j++) {
				maze[i][j] = num.charAt(j)-'0';//charŸ���� �� ���ڷ� �ɰ� ���� '0'�� ���� ���ڷ� ���氡��
			}
			
		}
		
		search(0,0);
		System.out.println(maze[n-1][m-1]);
		
		sc.close();
	}
}

