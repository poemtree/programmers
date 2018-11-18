package week3.codeTest1;

public class Main {

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		for(int i : new Solution().solution(progresses, speeds))
			System.out.println(i);
	}

}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        // 배열의 길이
        int len = progresses.length;
        
        // top 포인트..
        int top = 0;
        
        // 출력되는 프로그레스의 수
        int count = 0;
        
        // 아직 미완료된 작업을 체크.. 완료되면 더이상 진행하지 않기 위해
        boolean[] uncompleted = new boolean[len];
        for(int i = 0; i < len; i++) {
        	// 처음엔 모두 미완성..
        	uncompleted[i] = true;
        }
        
        // 모든 작업이 완료 될때 까지 진행..
        while(top < len) {
        	// 남아있는 작업들을 한 턴 씩 진행한다..
        	for(int i = top; i < len; i++) {
        		// 아직 미완성 된 작업만 진행
        		if(uncompleted[i]) {
        			// 작업을 진행도 만큼 늘리고 100 이상인 경우 완성으로 바꾼다..
        			if((progresses[i] += speeds[i]) >= 100) {
        				uncompleted[i] = false;
        			}
        		}
        	}
        	
        	// 전부 작업을 진행 했으면 가장 앞에 있는 작업이 완료되었는지 확인한다.. 범위를 넘기지 않도록 len과 비교는 필수
        	while(top < len && !uncompleted[top]) {
        		// 완료되었다면 출력을 위해 카운트를 하나 늘리고 top을 한칸 옮긴다.. 이렇게 하면 가장 앞에서 부터 연속된 완료 작업 수를 뽑아낼 수 있다..
    			count++;
        		top++;
        	}
        	
        	// 가장 앞에 있는 작업이 완료되었다면 카운트는 무조건 1이상.. 아니라면 무조건 0.. 작업이 하나라도 완료되었으면 출력을 한다..
        	if(count > 0) {
        		// answer의 크기를 하나 늘려서 현재 count를 가장 마지막에 넣어야 한다.. 가변형 list를 구현해도 되지만.. 굳이 힘쓰지 않고 구현이 쉬운 배열 복사로 함..
        		// 한 칸 늘리기 전 answer의 길이를 가져온다..
        		int preSize = answer.length;
        		
        		// temp의 크기는 preSize보다 하나 늘려준다
        		int[] temp = new int[preSize+1];
        		
        		// answer의 값들을 temp로 복사한다..
        		for(int i = 0; i < preSize; i++) {
        			temp[i] = answer[i];
        		}
        		
        		// 가장 뒤는 index가 preSize.. 여기에 현재 count를 넣어준다..
        		temp[preSize] = count;
        		
        		// answer를 temp로 바꿔주면 끝...
        		answer = temp;
        		
        		// count의 초기화는 기본..
        		count = 0;
        	}
        }        
        return answer;
    }
}