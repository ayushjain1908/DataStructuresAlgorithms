import java.util.*;
public class NthMostFrequentElement {
	private static class NumberFreqTuple{
		int number;
		int frequency;
		public NumberFreqTuple(int number, int frequency){
			this.number = number;
			this.frequency = frequency;
		}
	}
	private static void printTupleArray(NumberFreqTuple[] tupleArray){
		for(int i = 0; i < tupleArray.length; i++){
		   System.out.print("(" + tupleArray[i].number + "," + tupleArray[i].frequency + "), ");
		}
	}
	private static void swap(NumberFreqTuple[] tupleArray,int i, int j){
		NumberFreqTuple temp = tupleArray[i];
		tupleArray[i] = tupleArray[j];
		tupleArray[j] = temp;
	}
	private static void siftDown(NumberFreqTuple[] tupleArray, int index, int heapSize){
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int largest = index;
		if(left < heapSize && tupleArray[left].frequency > tupleArray[index].frequency ){
			largest = left;
		}
		if(right < heapSize && tupleArray[right].frequency > tupleArray[largest].frequency){
			largest = right;
		}
		if(largest != index){
			swap(tupleArray,index,largest);
			siftDown(tupleArray,largest,heapSize);
		}
	}
	private static void maxHeapify(NumberFreqTuple[] tupleArray){
		 int heapSize = tupleArray.length;
		 int parent = (tupleArray.length - 2)/2;
		 while(parent >= 0){
			 siftDown(tupleArray, parent, heapSize);
			 parent--;
		 }
	}
    public static int findNthMostFrequentElement(int[] array,int n){
    	HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
    	for(int i = 0; i < array.length; i++){
    		if(freqMap.get(array[i]) == null){
    			freqMap.put(array[i],1);
    		}
    		else{
    			int prev = freqMap.get(array[i]);
    			freqMap.put(array[i],prev + 1);
    		}
    	}
    	if(freqMap.size() < n){
    		return -1;
    	}
    	NumberFreqTuple[] tupleArray = new NumberFreqTuple[freqMap.size()];
    	int i = 0;
    	for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
    		NumberFreqTuple tuple = new NumberFreqTuple(entry.getKey(),entry.getValue());
    		tupleArray[i++] = tuple;
    	}
    	printTupleArray(tupleArray);
    	maxHeapify(tupleArray);
    	System.out.println();
    	printTupleArray(tupleArray);
    	int heapSize = tupleArray.length;
    	for(int k = 1 ; k<= n-1 ; k++){
    		swap(tupleArray, 0, heapSize - 1);
    		heapSize--;
    		siftDown(tupleArray,0, heapSize);
    		//System.out.println();
    		//printTupleArray(tupleArray);
    	}
    	int result = tupleArray[0].number;
    	return result; 	
    }
    public static void main(String[] args) {
    	int[] array = {1,2,2,2,4,4,4,4,5,5,5,5,5,7,7,8,8,8,8};
        int n = 4;
        System.out.println("\nNth most frequent number is:\n" + findNthMostFrequentElement(array,n));
	}
}
