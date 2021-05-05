package test;

import java.util.LinkedList;
import java.util.Scanner;

public class boj1966 {
	static int count = 1;
	static int n;
	static int m;
	static LinkedList<int[]> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();//testcase ����
		
		for(int i=0; i<test; i++) {//testcase��ŭ �ݺ�
			
			que = new LinkedList<int[]>();
			n = sc.nextInt();
			m = sc.nextInt();			

			for(int j=0; j<n; j++) {//���� ������ŭ �ݺ��ؼ�
				int pri = sc.nextInt();//�켱�����Է�
				que.add(new int[] {j, pri});//[�Էµ� ����, �켱����]�� ť�� ����
			}
			
			count = 0;//���°�� �μ�Ǵ��� Ȯ���� ����
			
			while(!que.isEmpty()) {//ť�� ����� ������
				int[] front = que.poll();//ù��° ���� ������
				boolean isMax = true;//�켱������ �ִ����� Ȯ���� ����
				
				for(int j=0; j<que.size(); j++) {//ť ������(���� ��)��ŭ �ݺ�
					
					if(front[1] < que.get(j)[1]) {//ù��° ������ �켱�������� �� ū ������ �ִٸ�
						que.add(front);//ù��° ������ ť�� ���� �ڿ� ����
						for(int k=0; k<j; k++) {//�켱������ ū ������ ù��° ���� ���̿� �����ϴ� ������
							que.add(que.poll());//���� ť�� ���� �ڿ� ����
						}
						isMax = false;//�켱������ �ִ밡 �ƴ�
						break;
					}
				}	
				
				if(isMax == false) {//�켱������ �ִ밡 �ƴϸ�
					continue;//����ؼ� ù��° ���� ������~ �ݺ� 
				}
				//�켱������ �ִ��̸� �ش� ���� �μ�
				count++;//�μ� Ƚ�� ����
				if(front[0]==m)//���� �ش繮���� ã�� �����̸�
					break;//����
				//�ش繮���� �ƴ϶�� �ٽ� ù��° ���� ������~ �ݺ�
			}			
			System.out.println(count);
		}
				
	}

}
