package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			que.add(i);//n���� ����� ����
		}
		
		System.out.print("<");
		
		while(que.size()!=1) {//ť�� ����� 1�϶����� �ݺ�
			for(int i=0; i<k-1; i++) {
				que.add(que.poll());//1 ~ k-1��° ������� �����ϰ� ť�� �������� �ٽ� �߰�
			}
			System.out.print(que.poll() + ", ");//k��° ��� ���, ����
		}
		
		System.out.print(que.poll()+">");//������ �Ѹ� ��� �� ����
		
		sc.close();
	}
}
