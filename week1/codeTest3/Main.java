package week1.codeTest3;

public class Main {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 0, 5};
		System.out.println(new Solution().solution(citations));
	}

}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        quickSort(citations, 0, length-1);
        
        while(answer < length) {
        	// index를 0부터 길이까지 증가시키며 비교한다.. index의 최대 값은 배열의 크기를 넘을 수 없다..
        	// 내림차순으로 정렬 된 배열에서...
        	// 현재 비교하는 논문이 현재 index+1 보다 작다면 현재 index가 h-index가 된다..
        	// 앞선 논문은 현재 index보다 무조건 같거나 크기 때문에 모든 조건이 성립한다.
        	// 하지만 현재 논문이 index+1보다 작다는 것은 최대 현재 index와 같다는 것이며 이는 뒤에 모든 논문은 비교할 필요가 없다는 뜻... 왜냐.. index가 늘어날 수 없기 때문에.. 
        	if(citations[answer] < answer+1) {
        		break;
        	}
        	answer++;
        }
 
        return answer;
    }
    
    public void quickSort(int[] array, int left, int right) {
    	int pivot = array[(left+right)/2];
    	int currentLeft = left;
    	int currentRight = right;
    	do {
    		//내림차순 정렬
    		while(array[currentLeft] > pivot) {currentLeft++;}
    		while(array[currentRight] < pivot) {currentRight--;}
    		if(currentLeft <= currentRight) {
    			int temp = array[currentLeft];
    			array[currentLeft++] = array[currentRight];
    			array[currentRight--] = temp;
    		}
    	} while(currentLeft <= currentRight);
    	
    	if(left < currentRight) quickSort(array, left, currentRight);
    	if(right > currentLeft) quickSort(array, currentLeft, right);
    	
    }
}