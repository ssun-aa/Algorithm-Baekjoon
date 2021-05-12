package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bracket = br.readLine();
		Stack<String> stack = new Stack<String>();
		int countR= 0, countS = 0;
		for(int i=0; i<bracket.length(); i++) {
			if(bracket.charAt(i) == '(') {
				countR++;
				stack.push("(");
			}
			else if(bracket.charAt(i) == ')') {
				countR--;
				if(countR >= 0) {
					if(stack.peek().equals("(")) {//¦�� �´� ��ȣ�� ��� ���ڷ� �ٲٱ�
						stack.pop();
						stack.push("2");
					}
					else {
						int resultR = 0;
						while(!stack.isEmpty()) {
							if(stack.peek().equals("[")) {//�߸��� ��ȣ
								System.out.println(0);
								return;
							}
							else if(stack.peek().equals("(")) {
								stack.pop();
								resultR *= 2;
								stack.push(String.valueOf(resultR));
								break;
							}
							else {//������ ��� ��� ���ϱ�
								resultR += Integer.parseInt(stack.pop());
							}
						}
					}
				}
			}
			if(bracket.charAt(i) == '[') {
				countS++;
				stack.push("[");
			}
			else if(bracket.charAt(i) == ']') {
				countS--;
				if(countS >= 0) {
					if(stack.peek().equals("[")) {//¦�� �´� ��ȣ�� ��� ���ڷ� �ٲٱ�
						stack.pop();
						stack.push("3");
					}
					else {
						int resultS = 0;
						while(!stack.isEmpty()) {
							if(stack.peek().equals("(")) {//�߸��� ��ȣ
								System.out.println(0);
								return;
							}
							else if(stack.peek().equals("[")) {
								stack.pop();
								resultS *= 3;
								stack.push(String.valueOf(resultS));
								break;
							}
							else {//������ ��� ��� ���ϱ�
								resultS += Integer.parseInt(stack.pop());
							}
						}
					}
				}
			}
			if(countR < 0 || countS < 0) {//���� ��ȣ���� �ݴ� ��ȣ�� ���� ������ ���
				System.out.println(0);
				return ;
			}
		}
		if(countR != 0 || countS != 0) {//�Էµ� ��ȣ�� ¦�� ���� �ʴ� ���
			System.out.println(0);
			return ;
		}
		int result = 0;
		while(!stack.isEmpty()) {//���ÿ� �ִ� ���� ���� ���ϱ�
			result += Integer.parseInt(stack.pop());
		}
		System.out.println(result);
	}

}
