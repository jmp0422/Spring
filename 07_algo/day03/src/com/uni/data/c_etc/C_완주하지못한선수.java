package com.uni.data.c_etc;

import java.util.HashMap;
import java.util.Set;
//완주하지 못한 선수
//문제 설명
//수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//
//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//completion의 길이는 participant의 길이보다 1 작습니다. ----------- 첨여자가 완주한 선수보다 1 많으면 완주하지못한선수는 1
//참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//참가자 중에는 동명이인이 있을 수 있습니다.
//입출력 예
//participant	completion	return
//["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
//입출력 예 설명
//예제 #1
//"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
//
//예제 #2
//"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
//
//예제 #3
//"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.


public class C_완주하지못한선수 {// 동명이인있다고 가정하고 풀어보자 
	// 참가하면 모두 1
	// 완주하면 -1
	
	// 그래서 참가하고 완주하면 0 인데 0 아닌경우는 완주하지 못한것 

	public static void main(String[] args) {
		
		
		 SolutionC solution = new SolutionC();

	        String[] participant1 = {"leo", "kiki", "eden"};
	        String[] completion1 = {"eden", "kiki"};
	        System.out.println(solution.solution(participant1, completion1));
	        
	        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
	        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
	        System.out.println(solution.solution(participant2, completion2));
	        
	        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
	        String[] completion3 = {"stanko", "ana", "mislav"};
	        System.out.println(solution.solution(participant3, completion3));
		
	}
}


class SolutionC {
    public String solution(String[] participant, String[] completion) {
//        HashMap<String, Integer> map = new HashMap<>();
//
//        //1. 참여자 목록을 만든다.
//        // 모든 참가자를 HashMap에 추가
//        for (String player : participant) {
//            map.put(player, map.getOrDefault(player, 0) + 1); //getOrDefault 값이있으면 가져오고 없으면 디폴트값셋팅
//        }
//      //2. 완주한 선수한 선수를 체크한다.
//        // 완주한 선수의 count를 1 감소
//        for (String player : completion) {
//            map.put(player, map.get(player) - 1);
//        }
//
//        // 완주하지 못한 선수 찾기  - 0 이아닌선수, 1명
//        for (String key : map.keySet()) {
//            if (map.get(key) != 0) {
//                return key;
//            }
//        }
//
//
//        return null;


        //1. 참여자 목록을 만든다.
        HashMap<String, Integer> list = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            list.put(participant[i], list.getOrDefault(participant[i], 0) + 1);
        }
        System.out.println(list);
        //2. 완주한 선수한 선수를 체크한다. 완주한선수면 -1
        for (int i = 0; i < completion.length; i++) {
            list.put(completion[i], list.get(completion[i]) - 1);
        }
        System.out.println(list);

        //3. 완주하지 못한 선수를 답안으로 작성한다.
        String answer = "";
        //hashmap을 꺼낼 때는 함수를 따로써야함.
        Set keys = list.keySet(); //{"eden", "kiki", "leo"}
        for (Object key : keys) {
            if(list.get(key) != 0) {
                answer = (String)key; // 완주하지 못한 선수는 1 이니까 멈춤
                break;
            }
        }


        return answer;
    }
}
		
		





