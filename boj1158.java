package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			que.add(i);//n명의 사람들 삽입
		}
		
		System.out.print("<");
		
		while(que.size()!=1) {//큐의 사이즈가 1일때까지 반복
			for(int i=0; i<k-1; i++) {
				que.add(que.poll());//1 ~ k-1번째 사람까지 삭제하고 큐의 마지막에 다시 추가
			}
			System.out.print(que.poll() + ", ");//k번째 사람 출력, 삭제
		}
		
		System.out.print(que.poll()+">");//마지막 한명 출력 후 삭제
		
		sc.close();
	}
}
