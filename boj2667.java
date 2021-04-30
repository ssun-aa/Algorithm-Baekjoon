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
	static private boolean visit[][];//true:�湮, false:�湮 �� 
	static private int count=0;
	static private int countArr[]= new int [25*25/2+1];//������ ũ�Ⱑ �ִ� 25, ��ĭ �ǳ� ��ĭ�� ���� ������ ��� �ִ��� ��
	static private int group=0;
	static private int dx[]= {-1,0,1,0};
	static private int dy[]= {0,-1,0,1};
	
	public static void bfs(int x, int y) {
		Queue<Home> que = new LinkedList<Home>();
		
		que.add(new Home(x,y));//�ش� ���� ť�� ����
		visit[x][y] = true;//�ش� �� �湮 ��
		
		while(!que.isEmpty()) {//ť�� ����� �� ����
			Home h = que.poll();//ť�� ù��° ���Ҹ� ����
			for(int i=0; i<4; i++) {
				
				int nextX = h.x+dx[i];//�������� �̵��� ��
				int nextY = h.y+dy[i];//��,��,�Ʒ�,������ ������
				
				if(nextX<0 || nextY<0 || nextX>=n || nextY>=n)//�̷γ��� ���� ����� ���
					continue;
				if(visit[nextX][nextY])//�湮 �ߴ� ���̸�
					continue;
				if(map[nextX][nextY]==0)//���� ������
					continue;
				
				que.add(new Home(nextX, nextY));//���� 3���� ��찡 �ƴ϶�� ť�� ���� ��ġ�� �Է�
				visit[nextX][nextY] = true;//�湮 ������ ǥ��
				count++;//�� ���� ����
			}
		}
	}
	
	public static void dfs(int x, int y) {
		
		visit[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];//�������� �̵��� ��
			int nextY = y + dy[i];//��,��,�Ʒ�,������ ������
			
			if(nextX<0 || nextY<0 || nextX>=n || nextY>=n)//�̷γ��� ���� ����� ���
				continue;
			if(visit[nextX][nextY])//�湮 �ߴ� ���̸�
				continue;
			if(map[nextX][nextY]==0)//���� ������
				continue;
			
			dfs(nextX,nextY);//���
			count++;//�� ���� ����
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		
		sc.nextLine();//�ٹٲ� ����!!
		
		for(int i=0; i<n; i++) {
			String line = sc.nextLine();//String Ÿ������ �Է¹޾Ƽ�
			for(int j=0; j<n; j++) {
				map[i][j] = line.charAt(j)-'0';//charŸ���� �� ���ڷ� �ɰ� ���� '0'�� ���� ���ڷ� ���氡��
			}
		}
				
		for(int i=0; i<n; i++) {//�̷� ��ü Ž��
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && visit[i][j]==false) {//���� �ְ� �湮 ���̶��
					count=1;
					dfs(i,j);
					//bfs(i,j);
					countArr[group++]=count;//�� ���� ����
				}
			}
		}
		
		Arrays.sort(countArr,0,group);//���� ���� �� ������ ����� �迭�� 0~������ ��ŭ�� �κ� �������� ����
		
		System.out.println(group);//���� �� ���
		for(int i=0; i<group; i++)
			System.out.println(countArr[i]);//���� ���� �� ���� ���
		
		sc.close();
	}

}
