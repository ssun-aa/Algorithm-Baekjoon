package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override//�켱���� ť ���� ������
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2))
					return 1;//�������� �����̱� ������ ���� ��쿡 ���� �ٲ�
				else if(Math.abs(o1) < Math.abs(o2))
					return -1;
				else {//���밪�� ���ٸ�
					if(o1 > o2)//������ �� ���ʿ� ������ ���� �ٲ�
						return 1;
					else if(o1 < o2)
						return -1;
					else 
						return 0;
				}
			}
		});
		for(int i=0; i<n; i++) {
			int x =Integer.parseInt(br.readLine());
			if(x != 0) {//0�� �ƴϸ� heap�� ����
				heap.add(x);
			}
			else {//0�� ���
				if(heap.size() == 0)//heap ����� 0�̸�
					System.out.println(0);//0���
				else
					System.out.println(heap.poll());//���� ���� ���밪 ���
			}
		}
	}
}
