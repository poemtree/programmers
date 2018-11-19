package week3.codeTest2;

public class Main {

	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		for(int i : new Solution().solution(heights)) {
			System.out.println(i);
		}
	}

}

class Solution {
    public int[] solution(int[] heights) {
    	
    	// 배열의 길이를 top으로 설정
        int top = heights.length;
        
        // 같은 길이의 결과 배열 생성
    	int[] answer = new int[top];
    	
    	// 탐색 인덱스
        int index;
        
        // top이 0보다 큰지 비교한 후 1감소..
        while(top-->0) {
        	// index 초기값을 top으로..
        	index = top;
        	
        	// index를 하나 줄여서 0이상인지 확인.. index의 값이 top보다 클 때 까지 반복..
        	while(--index >= 0 && heights[index] <= heights[top]) { }
        	
        	// top의 결과에 index +1을 저장.. 만약 더 큰 수가 하나도 없거나 top이 0의 위치일 때는 -1 +1 이기 때문에 0으로 저장 됨..
        	// index가 0이상인 경우 1을 더하므로 요구사항에 맞게 저장 됨..
        	answer[top] = index+1;
        }
        return answer;
    }
}