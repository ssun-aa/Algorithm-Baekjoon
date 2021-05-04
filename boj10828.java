package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10828 {
	
	static int size= 0;
	static int[] stack;

	public static void push(int number) {
		stack[size] = number;//�迭�� ���� ����
		size++;//�迭 �ε��� ����
	}
	
	public static void pop() {
		if(size==0)//�迭�� data�� ���� ���
			System.out.println("-1");
		else {//�迭�� data�� �ִ� ���
			System.out.println(stack[size-1]);
			size--;//�迭 �ε��� ����
		}
	}

	public static void size() {
		System.out.println(size);
	}

	public static void empty() {
		if(size==0)//�迭�� data�� ���� ���
			System.out.println("1");
		else//�迭�� data�� �ִ� ���
			System.out.println("0");
	}
	
	public static void top() {
		if(size==0)//�迭�� data�� ���� ���
			System.out.println("-1");
		else//�迭�� data�� �ִ� ���
			System.out.println(stack[size-1]);
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner�� ��� �ð��� �����ɸ��� ������ BufferReader�� �̿�

		int n = Integer.parseInt(br.readLine());//readLine�� String Ÿ���̶� integer�� ����
		stack = new int[n];//��ɾ� ����ŭ �迭 ����
		
		for(int i=0; i<n; i++) {
			String Line = br.readLine();//��ɾ�(+data) �Է�
			String[] order = Line.split(" ");//������ �������� ��ɾ�� data ����
			
			switch (order[0]) {//��ɾ ���� ����� switch��
				case "push": {
					int number = Integer.parseInt(order[1]);
					//push�� ��쿣 data�� ���� �ԷµǱ� ������ �Էµ� �����͸� integer�� �ٲ���
					push(number);
					break;
				}
				case "pop": {
					pop();
					break;
				}
				case "size": {
					size();
					break;
				}
				case "empty": {
					empty();
					break;
				}
				case "top": {
					top();
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + order);
				}
		}
	}

}
