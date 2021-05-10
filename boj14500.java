package test;

import java.util.Scanner;

public class boj14500 {

	static int n, m, max=0;
	static int paper[][];
	static boolean visit[][];
	static int dx[]= {-1, 0, 1, 0};
	static int dy[]= {0, -1, 0, 1};
	
	public static void exception(int x, int y) {
		int sum = paper[x][y];
		int wings = 4;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX<0 || nextY<0 || nextX>=n ||nextY>=m) {//������ ������ ����� 
				wings--;
				continue;
			}
			if(wings<3)//'��'����� ������ 3���� �־�� �ϼ��Ǳ� ������ 3�� �̸��ΰ�� ����
				return;
			min = Math.min(min, paper[nextX][nextY]);//���� �� ���� ���� �� ����
			sum += paper[nextX][nextY];
		}
		if(wings == 4){//'+'����� ��� ���� �ϳ��� ���� '��'����� ��
			sum -=min;
		}
		max = Math.max(max, sum);//�ִ밪 ����
	}
	public static void dfs(int x, int y, int sum, int depth) {
		if(depth == 4) {//4ĭ �� ä������
			max = Math.max(max, sum);//�ִ밪 ����
			return;
		}
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX<0 || nextY<0 || nextX>=n ||nextY>=m)//���� ĭ�� ������ ����� 
				continue;
			if(visit[nextX][nextY])//�̹� �湮 �� ĭ�̸�
				continue;
			visit[nextX][nextY] = true;
			dfs(nextX, nextY, sum+paper[nextX][nextY], depth+1);
			visit[nextX][nextY] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		paper = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(i,j,0,0);//'��'����� ������ ������ ���
				exception(i,j);//'��'���
			}
		}
		System.out.println(max);
	}

}
