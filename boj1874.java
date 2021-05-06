package test;

import java.util.Scanner;

public class boj1874 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int n = sc.nextInt();
		int num = 1;
		int size = 0;
		int stack[] = new int[n];
		int input[] = new int[n];//���� �Է� ���� ����
		
		for(int i=0; i<n; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			while(input[i]>=num) {//num���� �Էµ� ���� �� ū ���
				stack[size]=num;//stack�� num ����(push)
				size++;
				num++;
				sb.append("+\n");
			}
			if(input[i]==stack[size-1]) {//stack�� top ���� �Էµ� ���� ������
				stack[size-1]=0;//stack�� top �� ����
				size--;
				sb.append("-\n");
			}
			else {//stack�� top ���� �Էµ� ���� ���� ������; ���� ������ �ƴ�
				System.out.println("NO");
				return ;
			}
		}
		System.out.print(sb.toString());
		
		sc.close();
	}

}
