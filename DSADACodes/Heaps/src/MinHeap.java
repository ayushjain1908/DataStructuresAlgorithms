
public class MinHeap extends Heap {
  protected void siftDown(int index){
	  int leftIndex = getLeftChildIndex(index);
	  int rightIndex = getRightChildIndex(index);
	  int smaller = -1;
	  if(leftIndex != -1 && rightIndex != -1){
		  if(getElementAtIndex(leftIndex)<=getElementAtIndex(rightIndex)){
			  smaller = leftIndex;
		  }
		  else{
			  smaller = rightIndex;
		  }
	  }
	  else if(leftIndex != -1){
		  smaller = leftIndex;
	  }
	  else if(rightIndex != -1){
		  smaller = rightIndex;
	  }
	  else{
		  return;
	  }
	  if(getElementAtIndex(index) > getElementAtIndex(smaller)){
		  swap(index, smaller);
		  siftDown(smaller);
	  }
  }
  protected void siftUp(int index){
	  int parent = getParentIndex(index);
	  if(parent != -1 && getElementAtIndex(index) < getElementAtIndex(parent)){
		  swap(index, parent);
		  siftUp(parent);
	  }
  }
  public static void main(String[] args) {
	MinHeap minHeap = new MinHeap();
	minHeap.insert(9);
    minHeap.insert(4);
    minHeap.insert(17);
    minHeap.printHeapArray();
    minHeap.insert(6);
    minHeap.printHeapArray();

    minHeap.insert(100);
    minHeap.insert(20);
    minHeap.printHeapArray();
    minHeap.insert(2);
    minHeap.insert(1);
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.printHeapArray();

    minHeap.removeHighestPriority();
    minHeap.printHeapArray();
    minHeap.removeHighestPriority();
    minHeap.printHeapArray();
}
  
}
