// @author Ayush Jain
// Time : April 2016

public class AllSorts {
	
	//--------------------------- *******Selection Sort*********-----------------------------------  
	public static void selectionSort(int[] arr){
		for(int i = 0 ; i < arr.length - 1; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[i]){
					ArrayHelper.swap(arr, i, j);
				}
			}
			System.out.println("After iteration " + (i + 1));
			ArrayHelper.printArray(arr);
		}
	}
	//--------------------------- *******Bubble Sort*********--------------------------------------
	public static void bubbleSort(int[] arr){
		for(int i = 0 ; i < arr.length - 1 ; i++){
			boolean swapped = false;
			for(int j = arr.length - 1 ; j > i; j--){
				if(arr[j] < arr[j-1]){
					ArrayHelper.swap(arr, j, j - 1);
					swapped = true;
				}
			}
			System.out.println("After iteration " + (i + 1));
			ArrayHelper.printArray(arr);
			if(!swapped){
				break;
			}
		}
	}
	//--------------------------- *******Insertion Sort*********--------------------------------------
	public static void insertionSort(int[] arr){
		for(int i = 1 ; i < arr.length; i++){
			for(int j = i ; j > 0 ; j--){
				if(arr[j] >= arr[j-1]){
					break;
				}
				else{
					ArrayHelper.swap(arr, j, j - 1);
				}
			}
			System.out.println("After iteration " + (i));
			ArrayHelper.printArray(arr);
		}
	}
	//---------****Insertion Sort Modified, Helper for Shell Sort*********--------------------------------------
	public static void insertionSortMod(int[] arr, int start, int end, int increment){
		int k = 0 ;
		for(int i = start + increment ; i <= end ; i = i + increment ){
			for(int j = i ; j >= start + increment ; j = j - increment ){
				if(arr[j] >= arr[j-increment]){
					break;
				}
				else{
					ArrayHelper.swap(arr,j,j-increment);
				}
			}
	    k++;
		System.out.println("After iteration " + (k));
		ArrayHelper.printArray(arr);
	 }	
	}
	//--------------------------- *******Shell Sort*********--------------------------------------
	public static void shellSort(int[] arr){
		int increment  = 3 ; 
		while(increment > 0){
			for(int start = 0 ; start < increment ; start++){
				System.out.println("With starting index " + start  + " and increment " + increment);
				insertionSortMod(arr, start, arr.length - 1, increment);
			}
			increment--;
	    }
	}
	
	//--------------------------- *******Merge,Helper for Merge Sort-------------------------
	
	private static void merge(int[] arr, int[] aux, int low, int mid, int high){
		for(int k = low; k <= high ; k++){
			aux[k] = arr[k];
		}
		int i = low;
		int j = mid + 1;
		for(int k = low; k <= high; k++){
			if(i > mid){
				arr[k] = aux[j++];
			}
			else if(j > high){
				arr[k] = aux[i++];
			}
			else if (aux[j] < aux[i]){
				arr[k] = aux[j++];
			}
			else{
				arr[k] = aux[i++];
			}
		}
	}
	//--------------------------- *******Merge Sort*********--------------------------------------
	public static void mergeSort(int[] arr, int[] aux,int low, int high){
		if(high <= low){
			return;
		}
		int mid = low + (high-low)/2;
		mergeSort(arr,aux,low,mid);
		mergeSort(arr,aux,mid + 1,high);
		if(arr[mid] < arr[mid + 1]){
			return;
		}
		merge(arr,aux,low,mid,high);
		System.out.println("After merging.......");
		ArrayHelper.printArray(arr);
	}
	
	//---------------------*******Bottom-up Merge Sort****-----------------------------------------
	public static void bottomUpMergeSort(int[] arr, int[] aux){
		int n = arr.length;
		for(int sz = 1; sz < n; sz = 2 * sz){
			for(int low = 0; low < n - sz; low = low + 2*sz){
				merge(arr, aux, low, low + sz - 1, Math.min(low + sz + sz -1, n - 1));
			}
		}
	}
	
   //-------------------******Partition, Helper for Quick Sort*****--------------------------------
   public static int partition(int[] arr, int low, int high){
	   int i = low + 1;
	   int j = high;
	   int pe = arr[low];
	   while(true){
		   while(arr[i] < pe){
			   i++;
			   if(i > high){
				   break;
			   }
		   }
		   while(arr[j] > pe){
			   j--;
			   if(j < low){
				   break;
			   }
		   }
		   if(i>=j){
			   break;
		   }
		   ArrayHelper.swap(arr, i, j);
		   i++; // critical to increase i and decrease j,otherwise it may lead to infinite loop
		   j--;
	   }
	   ArrayHelper.swap(arr,low,j);
	   return j;
   }
   
   //---------------------******Quick Sort***********---------------------------------------------
   // ----------Should Shuffle the Array First to improve the average case(Randomization)---------
   public static void quickSort(int[] arr, int low, int high){
	   if(low >=high){
		   return;
	   }
	   int j = partition(arr, low, high);
	   System.out.println("Element " + arr[j] + " is put in its proper place at index " + j);
	   ArrayHelper.printArray(arr);
	   quickSort(arr, low, j-1);
	   quickSort(arr, j + 1, high);
   }
   
   //-------------------********3-Way Quick Sort****---------------------------------------------
   // ------------- Very Efficient in case of large no of Duplicate Keys --------------------------
   // ------------- Uses the Dutch National Flag Algorithm to do the Partitioning--------------------
   public static void threeWayQuickSort(int[] arr, int low, int high){
	  if(low >= high){
		  return;
	  }
	  int lt = low;
	  int i = low;
	  int gt = high;
	  int pe = arr[low];
	  while(i <= gt){
		  if(arr[i] == pe){
			  i++;
		  }
		  else if(arr[i] < pe){
			  ArrayHelper.swap(arr, i, lt);
			  lt++;
			  i++;
		  }
		  else{
			  ArrayHelper.swap(arr, i, gt);
			  gt--;
		  }
	  }
	 System.out.println("Placing element " + pe + " in right place " + "The array becomes : ");
	 ArrayHelper.printArray(arr);
	 threeWayQuickSort(arr, low, lt-1);
	 threeWayQuickSort(arr,gt+1, high);
   }
}
