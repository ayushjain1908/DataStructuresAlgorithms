
public abstract class Heap {
  private static int MAX_SIZE = 50;
  private int count = 0;
  private int[] array = new int[MAX_SIZE];
  public int getLeftChildIndex(int index){
	  int left = 2 * index + 1;
	  if(left >= count){
		  return -1;
	  }
	  return left;
  }
  public int getRightChildIndex(int index){
	  int right = 2 * index + 2;
	  if(right >= count){
		  return -1;
	  }
	  return right;
  }
  public int getParentIndex(int index){
	  if(index < 0 || index >= count){
		  return -1;
	  }
	  return (index - 1)/2;
  }
  protected void swap(int index1, int index2){
	  int temp = array[index1];
	  array[index1] = array[index2];
	  array[index2] = temp;
  }
  public int getCount(){
	  return count;
  }
  public boolean isEmpty(){
	  return count == 0;
  }
  public boolean isFull(){
	  return count == MAX_SIZE;
  }
  public int getElementAtIndex(int index){
	  return array[index];
  }
  public int getHighestPriority(){
	  return array[0];
  }
  protected abstract void siftUp(int index);
  protected abstract void siftDown(int index);
  public void insert(int value){
	  array[count] = value;
	  count++;
	  siftUp(count - 1);
  } 	
  public int removeHighestPriority(){
	  int ele = getHighestPriority();
	  array[0] = array[count - 1];
	  count--;
	  siftDown(0);
	  return ele;
  }
  public void printHeapArray() {
      for (int i = 0; i < count; i++) {
          System.out.print(array[i] + ", ");
      }
      System.out.println();
  }    
}
