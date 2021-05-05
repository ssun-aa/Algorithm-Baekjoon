package test;

import java.util.LinkedList;
import java.util.Scanner;

public class boj1966 {
	static int count = 1;
	static int n;
	static int m;
	static LinkedList<int[]> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();//testcase 개수
		
		for(int i=0; i<test; i++) {//testcase만큼 반복
			
			que = new LinkedList<int[]>();
			n = sc.nextInt();
			m = sc.nextInt();			

			for(int j=0; j<n; j++) {//문서 개수만큼 반복해서
				int pri = sc.nextInt();//우선순위입력
				que.add(new int[] {j, pri});//[입력된 순서, 우선순위]로 큐에 삽입
			}
			
			count = 0;//몇번째로 인쇄되는지 확인할 변수
			
			while(!que.isEmpty()) {//큐가 비어질 때까지
				int[] front = que.poll();//첫번째 문서 꺼내기
				boolean isMax = true;//우선순위가 최대인지 확인할 변수
				
				for(int j=0; j<que.size(); j++) {//큐 사이즈(문서 수)만큼 반복
					
					if(front[1] < que.get(j)[1]) {//첫번째 문서의 우선순위보다 더 큰 문서가 있다면
						que.add(front);//첫번째 문서를 큐의 가장 뒤에 삽입
						for(int k=0; k<j; k++) {//우선순위가 큰 문서와 첫번째 문서 사이에 존재하는 문서들
							que.add(que.poll());//전부 큐의 가장 뒤에 삽입
						}
						isMax = false;//우선순위가 최대가 아님
						break;
					}
				}	
				
				if(isMax == false) {//우선순위가 최대가 아니면
					continue;//계속해서 첫번째 문서 꺼내기~ 반복 
				}
				//우선순위가 최대이면 해당 문서 인쇄
				count++;//인쇄 횟수 증가
				if(front[0]==m)//만약 해당문서가 찾던 문서이면
					break;//종료
				//해당문서가 아니라면 다시 첫번째 문서 꺼내기~ 반복
			}			
			System.out.println(count);
		}
				
	}

}
