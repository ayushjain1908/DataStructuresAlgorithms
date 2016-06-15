
public class MaxHeap extends Heap{

	@Override
	protected void siftUp(int index) {
		int parent = getParentIndex(index);
		if(parent != -1 && getElementAtIndex(index) > getElementAtIndex(parent)){
			swap(index, parent);
			siftUp(parent);
		}
		
	}

	@Override
	protected void siftDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		  int rightIndex = getRightChildIndex(index);
		  int larger = -1;
		  if(leftIndex != -1 && rightIndex != -1){
			  if(getElementAtIndex(leftIndex) >= getElementAtIndex(rightIndex)){
				  larger = leftIndex;
			  }
			  else{
				  larger = rightIndex;
			  }
		  }
		  else if(leftIndex != -1){
			  larger = leftIndex;
		  }
		  else if(rightIndex != -1){
			  larger = rightIndex;
		  }
		  else{
			  return;
		  }
		  if(getElementAtIndex(index) < getElementAtIndex(larger)){
			  swap(index,larger);
			  siftDown(larger);
		  }
		
	}
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.insert(9);
        maxHeap.insert(4);
        maxHeap.insert(17);
        maxHeap.printHeapArray();
        maxHeap.insert(6);
        maxHeap.printHeapArray();

        maxHeap.insert(100);
        maxHeap.insert(20);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.printHeapArray();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.printHeapArray();

        maxHeap.removeHighestPriority();
        maxHeap.printHeapArray();
        maxHeap.removeHighestPriority();
        maxHeap.printHeapArray();
	}

}
