package week5.codeTest1;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(new Solution().solution(clothes));
	}

}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] item : clothes) {
        	String category = item[1];
        	if(map.containsKey(category)) {
        		map.put(category, map.get(category) + 1);
        	} else {
        		map.put(category, 1);
        	}
        }
        
        for(String category : map.keySet()) {
        	int num = map.get(category);
        	answer *= num+1;
        }
        
        return answer-1;
    }
}