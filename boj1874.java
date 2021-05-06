package test;

import java.util.Scanner;

public class boj1874 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int n = sc.nextInt();
		int num = 1;
		int size = 0;
		int stack[] = new int[n];
		int input[] = new int[n];//수열 입력 받을 변수
		
		for(int i=0; i<n; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			while(input[i]>=num) {//num보다 입력된 값이 더 큰 경우
				stack[size]=num;//stack에 num 삽입(push)
				size++;
				num++;
				sb.append("+\n");
			}
			if(input[i]==stack[size-1]) {//stack의 top 값과 입력된 값이 같으면
				stack[size-1]=0;//stack의 top 값 삭제
				size--;
				sb.append("-\n");
			}
			else {//stack의 top 값과 입력된 값이 같지 않으면; 스택 구조가 아님
				System.out.println("NO");
				return ;
			}
		}
		System.out.print(sb.toString());
		
		sc.close();
	}

}
