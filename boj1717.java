package test;
import java.util.Scanner;

public class boj1717 {
	static int n;
	static int parents[];
	
	public static int getParent(int x) {
		if(parents[x] == x) 
			return x;
		else 
			return parents[x] = getParent(parents[x]);
	}
	public static void connect(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a != b)
			parents[b] = a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		parents = new int[n+1];
		for(int i=0; i<=n; i++) {
			parents[i] = i;
		}
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();//������ �Է�
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(x == 0)//�����ڰ� 0�̸� ������
				connect(a,b);
			else {//������ 1�̸� ���� �������� Ȯ��
				if(getParent(a) == getParent(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		sc.close();
	}
}
