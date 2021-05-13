package test;
import java.util.Arrays;

class solutionHash2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
		Arrays.sort(phone_book);//문자열 정렬
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				//뒤쪽의 번호가 앞쪽의 번호로 시작하는지 확인
				answer = false;
				break;
			}
		}
        return answer;
    }
}