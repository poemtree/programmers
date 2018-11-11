package week2.codeTest1;

public class Main {

	public static void main(String[] args) {
		String arrangement ="()(((()())(())()))(())";
		System.out.println(new Solution().solution(arrangement));

	}

}

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        // 길이에 계속 접근하므로 변수로 저장.. String으로는 인덱스 접근이 힘드니 char[]로 변환
        int len = arrangement.length();
        char[] charArrangement = arrangement.toCharArray();
        // 쌓이는 막대의 수.. 열릴때마다 늘리고 하나 닫히면 빼준다..
        int stick = 0;
        // 닫히는 것이 레이져인지 스틱인지 확인하는 불리언..
        boolean flag = true;
        
        for(int i = 0; i < len ; i++) {
        	if(charArrangement[i]=='(') {
        		// 열리면 일단 스틱을 하나 늘리고 다음 닫히는 것은 레이져임을 표시
        		stick++;
        		flag = true;
        	} else {
        		// 닫혔을 때 레이져인지 스틱인지 확인..
        		if(flag) {
        			// 레이져이면 스틱에서 레이저의 수 하나를 빼서 스틱 수 만큼 조각을 늘려준다.. 그리고 다음 닫히는 것은 스틱임을 명시..
        			answer += --stick;
        			flag = false;
        		} else {
        			// 스틱이 닫히면 조각을 하나 늘려주고 스틱은 하나 감소 시킨다..
        			answer++;
        			stick--;
        		}
        	}
        }
        return answer;
    }
}