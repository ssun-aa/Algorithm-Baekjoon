package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj5430 {
	static StringBuffer sb;
	public static void print(boolean notReverse, ArrayDeque<Integer> deque) {
		sb = new StringBuffer();
		sb.append('[');
		if(deque.size()>0) {//�迭 �ȿ� ����� ���Ұ� ������
			if(notReverse) {//������
				while(!deque.isEmpty()) {//�迭�� ����� ������ 
					sb.append(deque.poll()).append(',');//���� ���� ��, sb�� �߰�, ','�� ���� �߰�
				}
			}
			else {//������
				while(!deque.isEmpty()) {//�迭�� ����� ������
					sb.append(deque.pollLast()).append(',');//���� ���� ��, sb�� �߰�
				}
			}
			sb.deleteCharAt(sb.length()-1);//������ ���� �ڿ� ���� ',' ����
		}
		sb.append(']');
		System.out.println(sb);
	}
	public static void AC(String p, ArrayDeque<Integer> deque) {
		boolean error = false;//Error �Ǻ�
		boolean notReverse = true;//������

		for(int i=0; i<p.length(); i++) {
			switch(p.charAt(i)) {//�Լ��� ���� ����
				case 'R':{//������ �Լ�
					notReverse = !notReverse;//���� �ٲٱ�
					break;
				}
				case 'D':{//ù��° ���� ������ �Լ�
					if(deque.size()==0) {//deque ������ 0 �̸�
						error = true;//����
						break;
					}
					else {
						if(notReverse)//�������̸�
							deque.pollFirst();//�� �� ���� ����
						else//�������̸�
							deque.pollLast();//�� �� ���� ����
						break;
					}
				}
			}
			if(error) {//error�� true �̸�
				System.out.println("error");//���� ���
				return;
			}
		}
		print(notReverse, deque);//error�� �ƴϸ� �迭 ���� ���� ����ϴ� �Լ� ȣ��
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());//testcase ����
		
		while(t-- > 0) {
			
			String p = br.readLine();//������ �Լ� �Է�
			int n = Integer.parseInt(br.readLine());//�迭 �� ������ �� �Է�
			ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
					
			st = new StringTokenizer(br.readLine(),"[],");//�Էµ� �迭�� '['�� ']'�� ','�� �������� ������ ����
														  //�迭 ���� �����͸� ����
			for(int i=0; i<n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));//�迭 ���� ������ deque�� ����
			}
			AC(p, deque);
		}
	}

}
