import java.util.*;
public class SubsetsOfSet {
    
	// Complexity is O(2^n) , complexity can not be less than this because 2^n number of 
	// subsets have to generated to get all the subsets 
	public static void findSubsets(List<List<Integer>> subsetList, List<Integer> numList){
		if(numList.isEmpty()){
			subsetList.add(new ArrayList<>());
			return;
		}
		int num = numList.get(0);
		numList.remove(0);
		findSubsets(subsetList,numList);
		List<List<Integer>> iteratingList = new ArrayList<>();
		iteratingList.addAll(subsetList);
		for(List<Integer> subset : iteratingList){
			List<Integer> newSubset = new ArrayList<Integer>();
			newSubset.addAll(subset);
			newSubset.add(num);
			subsetList.add(newSubset);
		}
	}
	public static void printSubsets(List<List<Integer>> subsetList){
		System.out.println("Total number of subsets : " + subsetList.size());
		for(List<Integer> subset : subsetList){
			System.out.print('{');
			for(int i  = 0 ; i < subset.size() - 1 ; i++){
				System.out.print(subset.get(i) + ", ");
			}
			if(subset.size() - 1 >= 0){
				System.out.print(subset.get(subset.size()-1));
			}
			System.out.println('}');
		}
	}
	public static void main(String[] args) {
		List<List<Integer>> subsetList = new ArrayList<>();
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(5);
		findSubsets(subsetList, numList);
		printSubsets(subsetList);
	}
}
