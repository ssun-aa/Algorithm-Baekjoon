package test;

import java.util.Arrays;
import java.util.Scanner;

public class boj1759 {
	static int L;
	static int C;
	static String[] code;
	static int count = 0;
	
	public static boolean check(String a) {//�ڵ� ���ǿ� �´��� Ȯ��
		int vowel = 0, consonant = 0;//������ ���� ���� ����
		
		for(int i=0; i<a.length(); i++) {//�ڵ� ���̸�ŭ �ݺ��ؼ�
			if(a.charAt(i)=='a' || a.charAt(i)=='e' || a.charAt(i)=='i' ||
				a.charAt(i)=='o' || a.charAt(i)=='u')//�����̸�
				vowel++;
			else//�����̸�
				consonant++;
		}
		if(vowel>=1 && consonant>=2)//���� �Ѱ� �̻�, ���� �ΰ� �̻��̸�
			return true;
		else
			return false;
	}
	
	public static void dfs(int x, String y) {
		if(y.length() == L) {//���� �ڵ��� ���̰� �Էµ� �ڵ���̿� ����������
			if(check(y))//�ڵ� ���� Ȯ���ϰ�
				System.out.println(y);//���
			return;
		}
		if(x+1<=C-1) {//��ͷ� �ݺ��� ���� ���ڰ� ������
			dfs(x+1,y.concat(code[x+1]));//���� ���ڸ� �ڵ忡 ������ ���
			dfs(x+1,y);//���� ���ڸ� �ڵ忡 ������ �ʰ� ���� �� ���
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();//�ڵ��� ����
		C = sc.nextInt();//�Էµ� ������ ����
		
		sc.nextLine();
		
		String string = null;
		string = sc.nextLine();//String Ÿ������ ���� ��ü(���� ����) �о��
		
		code = string.split(" ");//������ �������� ������ �� ���ھ� ����
		
		Arrays.sort(code);//������������ ����
		
		for(int i=0; i<=C-L; i++) {//�ڵ��� ���̰� L�̱� ������ C-L������ �ݺ�
			dfs(i,code[i]);
		}
		sc.close();
	}

}
