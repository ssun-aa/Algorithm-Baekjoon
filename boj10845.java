package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class boj10845 {
	public static Queue<Integer> que;
	public static int size = 0;// ť ������
	public static int last;//������ ������ ����; back()���� ���
	
	public static void push(int num) {
		que.add(num);//ť�� data ����
		last = num;//���������� ������ data ����
		size++;//ť ������ ����
	}
	
	public static void pop() {
		if(size==0)//ť�� data�� ���� ���
			System.out.println(-1);
		else {//ť�� data�� �ִ� ���
			System.out.println(que.poll());//ť�� ���� ��(���� ���� �����) data ��ȯ�� ����
			size--;
		}
	}
	
	public static void size() {
		System.out.println(size);
	}
	
	public static void empty() {
		if(size==0)//ť�� data�� ���� ���
			System.out.println(1);
		else//ť�� data�� �ִ� ���
			System.out.println(0);
	}
	
	public static void front() {
		if(size==0)//ť�� data�� ���� ���
			System.out.println(-1);
		else//ť�� data�� �ִ� ���
			System.out.println(que.peek());//ť�� ���� ��(���� ���� �����) data ��ȯ
	}
	
	public static void back() {
		if(size==0)//ť�� data�� ���� ���
			System.out.println(-1);
		else //ť�� data�� �ִ� ���
			System.out.println(last);//last�� ����� ���� ������ data ���
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner�� ��� �ð��� �����ɸ��� ������ BufferReader�� �̿�
		
		int n = Integer.parseInt(br.readLine());//readLine�� String Ÿ���̶� integer�� ����
		que = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();//��ɾ�(+data) �Է�
			String order[] = line.split(" ");//������ �������� ��ɾ�� data ����
			
			switch(order[0]) {//��ɾ ���� ����� switch��
				case "push":{
					int num = Integer.parseInt(order[1]);
					//push�� ��쿣 data�� ���� �ԷµǱ� ������ �Էµ� �����͸� integer�� �ٲ���
					push(num);
					break;
				}
				case "pop":{
					pop();
					break;
				}
				case "size":{
					size();
					break;
				}
				case "empty":{
					empty();
					break;
				}
				case "front":{
					front();
					break;
				}
				case "back":{
					back();
					break;
				}
					
			}
		}
	}

}
