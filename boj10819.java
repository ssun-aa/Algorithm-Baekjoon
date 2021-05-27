package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj10819 {
	static int n;
	static boolean visit[];
	static int newA[];//새로 생길 A배열
	static int A[];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		String[] arr= new String[n];
		visit = new boolean[n];
		newA = new int[n];

		arr = br.readLine().split(" ");//String타입으로 입력받아 공백기준으로 나눠 저장
		A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = Integer.parseInt(arr[i]);//String타입을 int타입으로 변경
		}
		func(0);
		System.out.println(max);
	}
	public static void func(int count){
		if(count == n){
			max = Math.max(cal(), max);//최대값 저장
		}
		for(int i=0; i<n; i++){
			if(!visit[i]){
				visit[i] = true;
				newA[count] = A[i];
				func(count+1);
				visit[i] = false;
			}
		}
	}
	public static int cal(){//주어진 식으로 계산 후 값 리턴
		int sum = 0;
		for(int i=0; i<n-1; i++){
			sum+=Math.abs(newA[i] - newA[i+1]);
		}
		return sum;
	}
}
