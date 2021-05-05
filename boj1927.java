package test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1927 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if(x!=0) {//0�� �ƴϸ� ť�� x �߰�
				priorityQueue.add(x);
			}
			else {//0�̸� ���� ���� �� ����� ����
				if(priorityQueue.size()==0)//ť�� ���������
					System.out.println(0);//0 ���
				else {//ť�� ������� ������
					System.out.println(priorityQueue.poll());//���� ������ ����� ����
				}
			}
		}
		sc.close();
	}

}
