package test;

import java.util.Scanner;

public class boj9012 {

	public static String vps(String string) {
		
		int x=0;//괄호 갯수 count
		
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i)=='(') {//'('일 경우
				x++;//x 증가
			}
			else if(string.charAt(i)==')') {//')'일 경우
				x--;//x 감소
				if(x<0)//괄호가 열리지 않았는데 먼저 닫히는 경우; ex. )(
					return "NO";
			}
		}
		if(x==0)//'('와 ')'의 개수가 동일한 경우
			return "YES";
		else//'('와 ')'의 개수가 동일하지 않은 경우
			return "NO";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();//줄바꿈 주의!!
		
		for(int i=0; i<n ;i++) {
			String a = sc.nextLine();
			System.out.println(vps(a));
		}
		
		sc.close();
	}

}
