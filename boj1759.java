package test;

import java.util.Arrays;
import java.util.Scanner;

public class boj1759 {
	static int L;
	static int C;
	static String[] code;
	static int count = 0;
	
	public static boolean check(String a) {//코드 조건에 맞는지 확인
		int vowel = 0, consonant = 0;//모음과 자음 세는 변수
		
		for(int i=0; i<a.length(); i++) {//코드 길이만큼 반복해서
			if(a.charAt(i)=='a' || a.charAt(i)=='e' || a.charAt(i)=='i' ||
				a.charAt(i)=='o' || a.charAt(i)=='u')//모음이면
				vowel++;
			else//자음이면
				consonant++;
		}
		if(vowel>=1 && consonant>=2)//모음 한개 이상, 자음 두개 이상이면
			return true;
		else
			return false;
	}
	
	public static void dfs(int x, String y) {
		if(y.length() == L) {//만든 코드의 길이가 입력된 코드길이와 같아졌으면
			if(check(y))//코드 조건 확인하고
				System.out.println(y);//출력
			return;
		}
		if(x+1<=C-1) {//재귀로 반복할 다음 문자가 있으면
			dfs(x+1,y.concat(code[x+1]));//다음 문자를 코드에 붙히고 재귀
			dfs(x+1,y);//다음 문자를 코드에 붙히지 않고 생략 후 재귀
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();//코드의 길이
		C = sc.nextInt();//입력될 문자의 개수
		
		sc.nextLine();
		
		String string = null;
		string = sc.nextLine();//String 타입으로 문자 전체(공백 포함) 읽어옴
		
		code = string.split(" ");//공백을 기준으로 나눠서 한 문자씩 저장
		
		Arrays.sort(code);//오름차순으로 정렬
		
		for(int i=0; i<=C-L; i++) {//코드의 길이가 L이기 때문에 C-L까지만 반복
			dfs(i,code[i]);
		}
		sc.close();
	}

}
