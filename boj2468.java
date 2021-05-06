package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
class region{
	int x;
	int y;
	public region(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class boj2468 {
	
	static int n;
	static int local[][];//���� ���� �迭
	static boolean sink[][];//���� ħ�� ���� �迭
	static boolean visit[][]; //���� �湮 ���� �迭
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void reset(){//visit�迭 �ʱ�ȭ
		for(boolean i[] : visit)
			Arrays.fill(i,false);
	}
	
	public static void bfs(int x, int y) {
		Queue<region> que = new LinkedList<region>();
		que.add(new region(x,y));//�ش� ������ ť�� ����
		visit[x][y] = true;//�ش� ���� �湮��
		
		while(!que.isEmpty()) {//ť�� ����� ������
			region reg = que.poll();//ť�� ù��° ������ ����
			for(int i=0; i<4 ;i++) {
				int nextX = reg.x + dx[i];
				int nextY = reg.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)//���� ������ ���������� ����� ���
					continue;
				if(visit[nextX][nextY] == true || sink[nextX][nextY] == true)//���� ������ �湮�� �� �ְų�, ���� �����
					continue;
				que.add(new region(nextX, nextY));//���� ��찡 �ƴϸ� ť�� �ش� ���� ����
				visit[nextX][nextY] = true;//�ش� ���� �湮��
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num=0, count = 0;
		Integer result[];
		n = sc.nextInt();//���� ���� 
		
		local = new int[n][n];//���� ���� �迭
		sink = new boolean[n][n];//���� ħ�� ���� �迭
		visit = new boolean[n][n];//���� �湮 ���� �迭
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				local[i][j]=sc.nextInt();//���� ���� �Է�
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();//�Է¹��� ������ ���������� �ߺ����� ������ set
		set.add(0);//�� �ȿ��� ��� �߰�!!
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				set.add(local[i][j]);//���� ���� ���� ����
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);

		result = new Integer[list.size()];//�ߺ����� ������ list�� size��ŭ result �迭 ����
		
		while(num < list.size()) {//������ ���̸�ŭ �� ���� �ݺ�
			count=0;//bfs Ƚ�� count �ʱ�ȭ
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(local[i][j]<=list.get(num)) {//���� �纸�� ���� ���̰� �������
						sink[i][j]=true;//���� ���
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(sink[i][j]==false && visit[i][j]==false) {//���� ����� �ʰ�, �湮�� �� ���� ���
						bfs(i,j);
						count++;//bfs Ƚ�� ����
					}
				}
			}
			result[num]=count;//��� ����
			num++;
		}
		Arrays.sort(result, Collections.reverseOrder());//result ������������ ����
		
		System.out.println(result[0]);
		
		sc.close();
	}

}
