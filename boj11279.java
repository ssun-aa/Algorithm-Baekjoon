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
			
			if(x == 0) {//0이 입력되면
				if(que.size()==0)//que가 비었으면
					System.out.println(0);//0 출력
				else
					System.out.println(que.poll());//que의 가장 큰 data 출력
			}
			else//0아닌 다른 값 입력시
				que.add(x);//que에 data로 삽입
		}

	}

}
