package test;

import java.util.Scanner;

public class boj9012 {

	public static String vps(String string) {
		
		int x=0;//��ȣ ���� count
		
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i)=='(') {//'('�� ���
				x++;//x ����
			}
			else if(string.charAt(i)==')') {//')'�� ���
				x--;//x ����
				if(x<0)//��ȣ�� ������ �ʾҴµ� ���� ������ ���; ex. )(
					return "NO";
			}
		}
		if(x==0)//'('�� ')'�� ������ ������ ���
			return "YES";
		else//'('�� ')'�� ������ �������� ���� ���
			return "NO";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();//�ٹٲ� ����!!
		
		for(int i=0; i<n ;i++) {
			String a = sc.nextLine();
			System.out.println(vps(a));
		}
		
		sc.close();
	}

}
