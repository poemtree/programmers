package week2.codeTest2;

public class Main {

	public static void main(String[] args) {
		int[] priorities = {8,9,8};
		int location = 0;
		System.out.println(new Solution().solution(priorities, location));

	}

}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //우선순위
        int priority = 9;
        
        //탐색의 시작
        int start = 0;
        
        //탐색의 끝
        int end = priorities.length-1;
        
        //스텍의 탑
        int top = 0;
        
        //탐색 인덱스
        int index;
        
        //탐색
        check : while(true) {
        	//index 초기값을 end로 시작..
        	index = end;
        	do {
        		// 바로 하나를 늘려 start 부터 탐색을 진행.. do while 문 이므로 end까지 이상없이 탐색 가능..
        		// 배열의 범위를 넘어가면 0으로 바꿔주고 아니면 1을 늘려주는 삼항식
        		index = (index<priorities.length-1)?index+1:0;
        		
        		// 현재 인덱스가 가장 높은 우선순위의 문서인지 검사
        		if(priorities[index]==priority) {
        			//스텍의 탑을 현재 인덱스로 변경
        			top = index;
        			//출력 순서를 하나 증가
        			answer++;
        			//만약 현재 인덱스가 찾고자 하는 문서라면 반복문 종료
        			if(index==location) {
        				break check;
        			}
        		}
        	} while(index != end);
        	// 배열 탐색이 끝났으므로 우선순위를 하나 낮춤
        	priority--;
        	//시작은 스텍의 탑부터
        	start = top;
        	//종료는 스텍보다 하나 앞까지.. 왜냐.. 우선순위에서 밀린 문서는 가장 끝으로 가기 때문에 스택의 탑 보다 앞에 있던 문서는 전부 뒤에 쌓여있다..
        	end = (start>0)?start-1:priorities.length-1;
        }
        
        return answer;
    }
}