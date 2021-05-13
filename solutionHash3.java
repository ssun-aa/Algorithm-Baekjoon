package test;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class solutionHash3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        //옷의 종류와 개수
		for(int i=0; i<clothes.length; i++){
            if(hash.containsKey(clothes[i][1]) == true) {//이미 옷의 종류가 존재하면
            	hash.replace(clothes[i][1], hash.get(clothes[i][1])+1);//해당 종류의 개수만 증가
            }
            else {
            	hash.put(clothes[i][1], 1);//새로 옷 종류 hash에 추가
            }           	
        }
		
		Collection<Integer> values = hash.values();//hash의 values만 뽑음
		Iterator<Integer> iterator = values.iterator();
		while(iterator.hasNext()) {
			int n = iterator.next();
			answer *= n+1;
		}
        return answer-1;
    }
}