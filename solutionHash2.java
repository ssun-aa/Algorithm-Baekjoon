package test;
import java.util.Arrays;

class solutionHash2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
		Arrays.sort(phone_book);//���ڿ� ����
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				//������ ��ȣ�� ������ ��ȣ�� �����ϴ��� Ȯ��
				answer = false;
				break;
			}
		}
        return answer;
    }
}