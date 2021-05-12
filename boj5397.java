package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer result;//���� ���
		Stack<Character> left, right;//Ŀ���� �������� ���� ���������� ����
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			left = new Stack<Character>();
			right = new Stack<Character>();
			result = new StringBuffer();
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				switch (line.charAt(j)) {
				case '<': {//Ŀ�� �������� �̵�
					if(!left.isEmpty())//���� ���� pop�ؼ� ������ ���ÿ� push�ϱ�
						right.push(left.pop());
					break;
				}
				case '>': {//Ŀ�� ���������� �̵�
					if(!right.isEmpty())//������ ���� pop�ؼ� ���� ���ÿ� push�ϱ�
						left.push(right.pop());
					break;
				}
				case '-': {//Ŀ�� ���� �� ����
					if(!left.isEmpty())
						left.pop();
					break;
				}
				default: //���� ���ÿ� ����
					left.push(line.charAt(j));
				}
			}
			for(Character j : left)//���� ������ �������̶� �ٷ� append
				result.append(j);
			while(!right.isEmpty())//������ ������ �������̶� pop�ؼ� append
				result.append(right.pop());
			System.out.println(result);
		}
	}
}
