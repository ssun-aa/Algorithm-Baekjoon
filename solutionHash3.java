package test;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class solutionHash3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        //���� ������ ����
		for(int i=0; i<clothes.length; i++){
            if(hash.containsKey(clothes[i][1]) == true) {//�̹� ���� ������ �����ϸ�
            	hash.replace(clothes[i][1], hash.get(clothes[i][1])+1);//�ش� ������ ������ ����
            }
            else {
            	hash.put(clothes[i][1], 1);//���� �� ���� hash�� �߰�
            }           	
        }
		
		Collection<Integer> values = hash.values();//hash�� values�� ����
		Iterator<Integer> iterator = values.iterator();
		while(iterator.hasNext()) {
			int n = iterator.next();
			answer *= n+1;
		}
        return answer-1;
    }
}