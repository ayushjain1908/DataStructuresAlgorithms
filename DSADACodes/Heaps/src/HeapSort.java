import java.util.Arrays;

public class HeapSort {

	private static void siftDown(int[] array,int index, int heapSize){
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int larger = index;
		if(left < heapSize && array[left] > array[index]){
			larger = left;
		}
		if(right < heapSize && array[right] > array[larger]){
			larger = right;
		}
		if(larger != index){
			swap(array,index,larger);
			siftDown(array,larger,heapSize);
		}
	
	}
	private static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static void heapify(int[] array){
		int last = array.length - 1;
		int heapSize = array.length;
		int parent = (last - 1)/2;
		while(parent >= 0){
			siftDown(array, parent, heapSize);
			parent--;
		}
	}
	public static void heapSort(int[] array){
		heapify(array);
		int heapSize = array.length;
		while(heapSize > 0){
			swap(array, 0, heapSize - 1);
			heapSize--;
			siftDown(array, 0, heapSize);
		}
	}
	public static void main(String[] args) {
		int[] array = {12, 35, 87, 26, 9, 28, 7,124};
        System.out.println("Original Array:\t\t" + Arrays.toString(array));
        heapSort(array);
        System.out.println("Sorted Array:\t\t" + Arrays.toString(array));
	}
}
