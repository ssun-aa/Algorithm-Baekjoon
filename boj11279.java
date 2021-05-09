package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {//0�� �ԷµǸ�
				if(que.size()==0)//que�� �������
					System.out.println(0);//0 ���
				else
					System.out.println(que.poll());//que�� ���� ū data ���
			}
			else//0�ƴ� �ٸ� �� �Է½�
				que.add(x);//que�� data�� ����
		}

	}

}
