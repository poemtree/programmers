package week4.codeTest1;

public class Main {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(new Solution().solution(participant, completion));
	}

}

class Solution {
    public String solution(String[] participant, String[] completion) {
/*        
        HashSet<String> set = new HashSet<>();

        for(String s : participant) {
        	set.put(s);
        }
        
        for(String s : completion) {
        	set.delete(s);
        }       
        
        return set.getLastKey();*/
    	
    	quickSort(participant, 0, participant.length-1);
    	quickSort(completion, 0, completion.length-1);
    	int i = 0;
		while(i<completion.length && completion[i].equals(participant[i])){i++;}

    	return participant[i];
    	
    	
    }
    
    public void quickSort(String[] array, int left, int right) {
    	String pivot = array[(left+right)/2];
    	int currentLeft = left;
    	int currentRight = right;
    	do {
    		//내림차순 정렬
    		while(array[currentLeft].compareTo(pivot) < 0) {currentLeft++;}
    		while(array[currentRight].compareTo(pivot) > 0) {currentRight--;}
    		if(currentLeft <= currentRight) {
    			String temp = array[currentLeft];
    			array[currentLeft++] = array[currentRight];
    			array[currentRight--] = temp;
    		}
    	} while(currentLeft <= currentRight);
    	
    	if(left < currentRight) quickSort(array, left, currentRight);
    	if(right > currentLeft) quickSort(array, currentLeft, right);
    	
    }
}

/*class HashNode<T> {
	private T key;
	private HashNode<T> preNode;
	
	public HashNode() {	}
	
	public HashNode(T t) {
		key = t;
	}
	
	public void setPreNode(HashNode<T> preNode) {
		this.preNode = preNode;
	}
	
	public HashNode<T> getPreNode() {
		return preNode;
	}
	
	public T getKey() {
		return key;
	}
	
	public boolean hasPre() {
		return preNode != null;
	}
}

class HashSet<T> {
	private HashNode<T> lastNode;
	
	public HashSet() {	}
	
	public void put(T t) {	
		if(lastNode != null) {
			HashNode<T> temp = new HashNode<T>(t);
			temp.setPreNode(lastNode);
			lastNode = temp;
		} else {
			lastNode = new HashNode<T>(t);
		}
	}
	
	public boolean delete(T t) {
		if(lastNode != null ) {
			if(lastNode.getKey().equals(t)) {
				lastNode = lastNode.getPreNode();
				return true;
			}

			HashNode<T> temp = lastNode;
			HashNode<T> preNode;
			while(temp.hasPre()) {
				preNode = temp.getPreNode();
				if(preNode.getKey().equals(t)) {
					temp.setPreNode(preNode.getPreNode());
					return true;
				}
				temp = preNode;
			}
			
		}
		return false;
	}
	
	public T getLastKey() {
		return lastNode.getKey();
	}
}
*/