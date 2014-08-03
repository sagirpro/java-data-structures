package Quick;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 *@author Sagiruddin Mondal <sagir.pro@gmail.com>
 */

public class QuickSort {
 
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
 
		QuickSort app = new QuickSort();
		
		//provide any integer input inside bracket sheparating by comma
        List<Integer> input  = Lists.newArrayList(4, 3, 543, 112, 23, 1);		
		
	    //Before sort
	    System.out.println("Input =" + input);
		//sending to sort
	    List<Integer> sorted = app.quicksort(input);
	    //After sort
	    System.out.println("Sorted Data" + sorted);
	    
	}
	
	/**
	 * This method sort the input ArrayList using quick sort algorithm.
	 */
	
	private List<Integer> quicksort(List<Integer> input){
		
		if(input.size() <= 1){
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.size() / 2);
		int pivot = input.get(middle);
 
		List<Integer> less = new ArrayList<Integer>();
		List<Integer> greater = new ArrayList<Integer>();
		
		for (int i = 0; i < input.size(); i++) {
			if(input.get(i) <= pivot){
				if(i == middle){
					continue;
				}
				less.add(input.get(i));
			}
			else{
				greater.add(input.get(i));
			}
		}
		
		return concatenate(quicksort(less), pivot, quicksort(greater));
	}
	

	private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < less.size(); i++) {
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for (int i = 0; i < greater.size(); i++) {
			list.add(greater.get(i));
		}
		
		return list;
	}
 
}