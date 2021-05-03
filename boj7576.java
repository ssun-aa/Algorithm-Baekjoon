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
	static int dx[] = {-1, 0, 1, 0};//��,��,�Ʒ�,������ ������
	static int dy[] = {0, -1, 0 ,1};//���� �丶�� ��ġ 
	
	public static boolean checkTomato() {//���� ���� �丶��(=0)�� ���� ��� false��ȯ
										//��� �;��� ���(=1)���� true ��ȯ
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
		int day = 0; //�ּ� �ϼ� ���� ����
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 1)//�̹� ���� �丶�並 ã�Ƽ�
					que.add(new tomato(i,j,0));//���� �丶�並 que�� ���Ͽ� bfs ����
			}
		}
		
		while(!que.isEmpty()) {//ť�� ����� �� ����
			tomato tom = que.poll();//ť�� ù��° ���Ҹ� ����
			day= tom.day;
			
			for(int i=0; i<4; i++) {
				int nextX = tom.x + dx[i];
				int nextY = tom.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) //�ڽ� ������ ����� ���
					continue;
					
				if(box[nextX][nextY]!=0) //�̹� ���� �丶���� ���
					continue;
				
				que.add(new tomato(nextX, nextY, day+1));//���� ��츦 �����ϰ��� day+1�Ͽ� ť�� ����
				box[nextX][nextY]=1;//���� �丶��� ǥ��
			}
		}
		if(checkTomato())
			System.out.println(day);//��� �丶�䰡 ���� ��� ��¥ ���
		else
			System.out.println(-1);//���� �ʴ� �丶�䰡 �ִ� ��� -1 ���
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
