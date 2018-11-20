package week3.codeTest3;

public class Main{
	public static void main(String[] args) {
		int[] prices = {498,501,470,489};
		for(int i : new Solution().solution(prices)) {
			System.out.println(i);
		}
	}
}

class Solution {
    public int[] solution(int[] prices) {
    	
    	// 현재 비교중인 값을 가르키는 포이트
    	int top = 0;
    	
    	// 배열의 길이
    	int len = prices.length;
    	
    	// 같은 길이 만큼 결과 배열 생성
    	int[] answer = new int[len];
        
    	// 탐색을 위한 인덱스
    	int index;
    	
    	// 초를 계산할 카운트
    	int count;
    	
    	// 모든 결과를 계산할 때 까지 반복
        while(top < len) {
        	
        	// 카운트의 초기값은 0
        	count = 0;
        	
        	// 인덱스는 대상의 하나 앞에서 부터..
        	index = top+1;
        	
        	// 인덱스가 길이를 넘지 않을 때 까지 반복.. 이렇게 하면 마지막 값은 알아서 0이 된다.. 
        	while( index < len) {
        		// 초를 1 늘려준다..
        		count++;
        		
        		// 인덱스를 늘려주기 전 대상보다 값이 낮아졌는지 비교.. 낮아졌으면 종료
        		if(prices[index++] < prices[top]) {
        			break;
        		}
        	}
        	
        	// 계산된 초를 결과 배열에 저장
        	answer[top++] = count;
        }
        return answer;
    }
}