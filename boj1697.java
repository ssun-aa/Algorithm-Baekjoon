package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {

	static int visit[] = new int[100001];//�湮 �� �ð� üũ
	static int k;
	public static void bfs(int num) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(num);//������ ��ġ ����
		visit[num] = 1;//�湮��, �ð� 1�� �ʱ�ȭ
		
		while(!que.isEmpty()) {//ť�� ����� ������
			int x = que.poll();
			
			for(int i=0; i<3; i++) {
				int next;//������ ���� ��ġ
				
				if(i == 0)
					next = x - 1;//�ڷ� ��ĭ
				else if(i == 1)
					next = x + 1;//������ ��ĭ
				else
					next = x * 2;//�����̵�
				
				if(next == k) {//������ġ�� ������ġ�� ���ٸ�
					System.out.println(visit[x]);//�ɸ� �ð� ���
					return;
				}
				if(next>=0 && next<=100000 && visit[next] == 0) {
					//���� ��ġ�� ���� ���̰� �湮���� ���ٸ�
					que.add(next);//ť�� ���� ��ġ ����
					visit[next] = visit[x] + 1;//�ð� 1�� ���� 
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//������ ��ġ
		k = sc.nextInt();//���� ��ġ
		
		if(n == k)//ó���� ����� ������ ��ġ�� �������
			System.out.println(0);
		else
			bfs(n);//������ ��ġ
		
		sc.close();
	}

}
