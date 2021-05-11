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
			@Override//우선순위 큐 정렬 재정의
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2))
					return 1;//오름차순 정렬이기 때문에 위의 경우에 순서 바뀜
				else if(Math.abs(o1) < Math.abs(o2))
					return -1;
				else {//절대값이 같다면
					if(o1 > o2)//음수가 더 앞쪽에 오도록 순서 바꿈
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
			if(x != 0) {//0이 아니면 heap에 삽입
				heap.add(x);
			}
			else {//0일 경우
				if(heap.size() == 0)//heap 사이즈가 0이면
					System.out.println(0);//0출력
				else
					System.out.println(heap.poll());//가장 작은 절대값 출력
			}
		}
	}
}
