package test;
import java.util.HashMap;

class solutionHash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		//���� �̸��� �ش� �̸� �ο�; �������� ������
		for(int i=0; i<participant.length; i++) {
			if(hash.containsKey(participant[i]) == true) {//�����ϴ� ���� �̸��� �̹� ������
				hash.replace(participant[i], hash.get(participant[i])+1);//������������ �ο����� ����
			}
			else {//�����ϴ� ���� �̸��� ���� ���
				hash.put(participant[i], 1);//���� hash�� �߰�
			}
		}
		for(int i=0; i<completion.length; i++) {
			if(hash.get(completion[i]) != null) {//������ ���� �̸��� ������
				hash.replace(completion[i], hash.get(completion[i])-1);//�ο� ����
				if(hash.get(completion[i]) == 0)//�ش� �̸��� ���� ����� 0���� �Ǹ�
					hash.remove(completion[i]);//hash���� ����
			}
		}
		answer = hash.keySet().iterator().next();//hash�� �����ִ� �̸� ���
		return answer;
    }
}