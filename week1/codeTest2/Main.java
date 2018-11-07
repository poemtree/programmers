package week1.codeTest2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0,99,9,10};
		System.out.println(new Solution().solution(numbers));
	}

}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
/*        int len = numbers.length;
        int[] sortedNumbers = new int[len];
        sortedNumbers[0] = numbers[0];
        for(int i = 0; i < len; i++) {
        	int num = numbers[i];
        	for(int j = 0; j < i; j++) {
        		if(checkNum(sortedNumbers[j], num)) {
    				int temp = sortedNumbers[j];
    				sortedNumbers[j] = num;
    				num = temp;
        		}
        	}
        	sortedNumbers[i] = num;
        }
        for(int num : sortedNumbers) {
        	answer += String.valueOf(num);
        }*/
        sort(numbers, 0, numbers.length-1);
        for(int num : numbers) {
        	answer += String.valueOf(num);
        }
        return answer.charAt(0)=='0'?"0":answer;
    }
    
    public boolean checkNum(int numA, int numB) {
    	int figureA = 10;
    	int figureB = 10;
  	
    	// num의 자릿수 확인.. 1의 자리는 10.. 10의 자리는 100.. N의 자리는 N*10..
    	while(figureA <= numA) {figureA *= 10;};
    	while(figureB <= numB) {figureB *= 10;};
    	
    	return numA*figureB + numB > numB*figureA + numA;
    }

    public void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(checkNum(data[left] , pivot)) left++;
            while(checkNum(pivot, data[right])) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
    
}
