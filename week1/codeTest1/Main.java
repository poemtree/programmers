package week1.codeTest1;

public class Main {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		for(int i : new Solution().solution(array, commands))
			System.out.println(i);

	}

}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int turn = commands.length;
        int start;
        int end = 0;
        int[] answer = new int[turn];
        int[] temp;
        for(int i = 0; i < turn; i++) {
        	start = commands[i][0] - 1;
        	end = commands[i][1];
        	temp = new int[end - start];
        	int index = 0;
        	for(int j = start; j < end; j++ ) {
        		temp[index++] = array[j];
        	}
        	temp = sortArray(temp);
        	answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
    public int[] sortArray(int[] array) {
    	int len = array.length;
    	int[] sortedArray = new int[len];
    	sortedArray[0] = array[0];
    	for(int i = 1; i < len; i++ ) {
    		int num = array[i];
    		for(int j = 0; j < i; j++) {
    			if(sortedArray[j] > num) {
    				int temp = sortedArray[j];
    				sortedArray[j] = num;
    				num = temp;
    			}
    		}
    		sortedArray[i] = num;
    	}
    	return sortedArray;
    }
}