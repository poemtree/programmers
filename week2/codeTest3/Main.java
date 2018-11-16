package week2.codeTest3;

public class Main {

	public static void main(String[] args) {
		
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
	}

}


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 진입 대기중인 차
        int index = 0;
        
        // 건너야 하는 차의 수
        int turn = truck_weights.length;
        
        // 다리..
        Bridge bridge = new Bridge(bridge_length, weight);
        
        // 모든 차가 다리를 건너고 다리 위에 차가 없을 때 까지 반복
        while(index < turn || bridge.getWeights() > 0) {
        	
        	// 다리가 꽉 찾다면 가장 앞에 차는 다리를 빠져나간다
        	if(bridge.isFull()) {
        		bridge.outTruck();
        	}
        	
        	// 대기중인 차가 있고 다리가 하중을 견딜 수 있다면 차가 진입한다
    		if(index < turn && bridge.checkLimit(truck_weights[index])) {
    			bridge.inTruck(truck_weights[index++]);
    		} else {
    			// 그렇지 않다면 공간을 한칸 비운다
    			bridge.inTruck(0);	
    		}
    		
    		// 시간이 흐른다
    		answer++;
        }
        return answer;
    }
}

// 다리 큐.. 원형 큐로 구현.. 그래야 계속 돌릴 수 있으니까..
class Bridge {
	
	// 가장 앞.. 여기는 항상 비어있는 것으로 간주..
	private int front;
	
	// 가장 뒤.. 한칸 늘리고 삽입..
	private int real;
	
	// 크기.. 실제 다리 길이 보다 한 칸 늘려야 한다.. 원형 큐 이기 때문에 한 칸은 사용할 수 없기 때문...
	private int size;
	
	// 현재 다리에 가해지는 하중
	private int weights;
	
	// 최대 무게..
	private int limit;
	
	// 다리에 올라와 있는 차들.. 시간에 따라 한 칸 씩 움직이며 빈 공간도 있을 수 있다..
	private int[] list;
	
	public Bridge(int size, int limit) {
		front = 0;
		real = 0;
		this.size = size+1;
		weights = 0;
		this.limit = limit;
		list = new int[this.size];
	}
	
	// 대기중인 차의 무게를 다리가 견딜 수 있는지 확인..
	public boolean checkLimit(int truck_weight) {
		return this.weights + truck_weight <= limit;
	}
	
	// 다리가 꽉 찾는지 확인.. 빈 공간도 무게가 0인 차량으로 간주..
	public boolean isFull() {
		return (real + 1) % size == front;
	}
	
	// 비었는지 확인..
	public boolean isEmpty() {
		return real == front;
	}
	
	// 다리에 들어온다.. 하중을 늘려준다
	public void inTruck(int truck_weight) {
		real = (real + 1) % size;
		list[real] = truck_weight;
		weights += list[real];
	}
	
	// 다리에서 나간다.. 하중을 빼준다..
	public void outTruck() {
		front = (front + 1) % size;
		weights -= list[front];		
	}
	
	// 현재 다리에 가해지는 하중..
	public int getWeights() {
		return weights;
	}
}