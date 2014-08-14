// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package quick;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * The Quicksort program simply take a series of input in a arraylist and sort
 * them using quicksort algorithm.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-14
 */

public class QuickSort {


	public static void main(String[] args) {

		QuickSort app = new QuickSort();
		List<Integer> input = Lists.newArrayList(4, 3, 543, 112, 23, 1);
		System.out.println("Input =" + input);
		List<Integer> sorted = app.quicksort(input);
		System.out.println("Sorted Data" + sorted);
	}

	// =============================================================================
	// This method sort the input ArrayList using quick sort algorithm.
	// =============================================================================

	private List<Integer> quicksort(List<Integer> input) {

		if (input.size() <= 1) {
			return input;
		}

		int middle = (int) Math.ceil((double) input.size() / 2);
		int pivot = input.get(middle);

		List<Integer> less = new ArrayList<Integer>();
		List<Integer> greater = new ArrayList<Integer>();

		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) <= pivot) {
				if (i == middle) {
					continue;
				}
				less.add(input.get(i));
			} else {
				greater.add(input.get(i));
			}
		}

		return concatenate(quicksort(less), pivot, quicksort(greater));
	}

	private List<Integer> concatenate(List<Integer> less, int pivot,
			List<Integer> greater) {

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