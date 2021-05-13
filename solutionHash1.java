package test;
import java.util.HashMap;

class solutionHash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		//선수 이름과 해당 이름 인원; 동명이인 때문에
		for(int i=0; i<participant.length; i++) {
			if(hash.containsKey(participant[i]) == true) {//참여하는 선수 이름이 이미 있으면
				hash.replace(participant[i], hash.get(participant[i])+1);//동명이인으로 인원수만 증가
			}
			else {//참여하는 선수 이름이 없는 경우
				hash.put(participant[i], 1);//새로 hash에 추가
			}
		}
		for(int i=0; i<completion.length; i++) {
			if(hash.get(completion[i]) != null) {//완주한 선수 이름이 있으면
				hash.replace(completion[i], hash.get(completion[i])-1);//인원 감소
				if(hash.get(completion[i]) == 0)//해당 이름을 가진 사람이 0명이 되면
					hash.remove(completion[i]);//hash에서 삭제
			}
		}
		answer = hash.keySet().iterator().next();//hash에 남아있는 이름 출력
		return answer;
    }
}