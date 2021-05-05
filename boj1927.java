package test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1927 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if(x!=0) {//0이 아니면 큐에 x 추가
				priorityQueue.add(x);
			}
			else {//0이면 가장 작은 값 출력후 삭제
				if(priorityQueue.size()==0)//큐가 비어있으면
					System.out.println(0);//0 출력
				else {//큐가 비어있지 않으면
					System.out.println(priorityQueue.poll());//가장 작은값 출력후 삭제
				}
			}
		}
		sc.close();
	}

}
