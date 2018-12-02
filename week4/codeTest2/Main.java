package week4.codeTest2;

import java.util.HashSet;
import java.util.Iterator;
public class Main {

	public static void main(String[] args) {
		String[] phone_book = {"12", "123"};
		System.out.println(new Solution().solution(phone_book));
		
	}

}

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<MyString> set = new HashSet<>();

        for(String num : phone_book) {
        	Iterator<MyString> it = set.iterator();
        	MyString ms = new MyString(num);
        	while(it.hasNext()) {
        		if(it.next().equals(ms)) {
        			return false;
        		}
        	}
    		set.add(ms);

        }
        return true;
    }
}

class MyString {
	private String key;
	
	public MyString(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	
	public boolean equals(Object obj) {
		boolean result;
		String anotherKey = ((MyString)obj).getKey();
		if(anotherKey.length() < key.length()) {
			result = key.startsWith(anotherKey);
		} else if(anotherKey.length() > key.length()){
			result = anotherKey.startsWith(key);
		} else {
			result = key.equals(anotherKey);
		}
		return result;

	}
	
	public int hashCode() {
		return key.hashCode();
	}
}