package test;

import java.util.Scanner;

public class boj1182 {
	static int n;
	static int s;
	static int count = 0;
	static int arr[];
	public static void dfs(int x, int sum){//������ ���° ��������, �� ��
		if(x==n) {//������ ���� n��° ���Ҷ��
			if(sum==s)//�� ���� �Է¹��� �հ� ���ٸ�
				count++;//����� �� ����
			return ;
		}
		dfs(x+1, sum+arr[x]);//�̹� ���Ҹ� �տ� ���ؼ� ���� ���ҷ� ���
		dfs(x+1, sum);//�̹� ���Ҹ� �տ� ������ �ʰ� ���� ���ҷ� ���
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]= sc.nextInt();//���� �Է� �ޱ�
		}
		
		dfs(0,0);
		
		if(s==0)//�κ������� ���� 0�� ��쿡�� �������� ��쵵 �־ -1
			System.out.println(count-1);
		else
			System.out.println(count);
		
		sc.close();
	}

}
