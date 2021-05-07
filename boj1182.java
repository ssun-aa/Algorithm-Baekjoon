package test;

import java.util.Scanner;

public class boj1182 {
	static int n;
	static int s;
	static int count = 0;
	static int arr[];
	public static void dfs(int x, int sum){//수열의 몇번째 원소인지, 총 합
		if(x==n) {//수열의 끝인 n번째 원소라면
			if(sum==s)//그 합이 입력받은 합과 같다면
				count++;//경우의 수 증가
			return ;
		}
		dfs(x+1, sum+arr[x]);//이번 원소를 합에 더해서 다음 원소로 재귀
		dfs(x+1, sum);//이번 원소를 합에 더하지 않고 다음 원소로 재귀
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]= sc.nextInt();//수열 입력 받기
		}
		
		dfs(0,0);
		
		if(s==0)//부분집합의 합이 0인 경우에는 공집합의 경우도 있어서 -1
			System.out.println(count-1);
		else
			System.out.println(count);
		
		sc.close();
	}

}
