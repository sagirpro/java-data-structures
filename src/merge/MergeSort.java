// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package merge;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * The MergeSort program simply take a series of input in a arraylist and sort
 * them using Merge Sort algorithm.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-09
 */

public class MergeSort {


	public static void main(String[] args) {
		MergeSort app = new MergeSort();
		List<Integer> input = Lists.newArrayList(4, 3, 543, 112, 23, 1);
		System.out.println("Input =" + input);
		Iterable<Integer> sorted = app.pertition(input);
		System.out.println("Sorted Data" + sorted);
	}

	private Iterable<Integer> pertition(List<Integer> input) {

		if (input.size() <= 1) {
			return input;
		}
		List<Integer> first = new ArrayList<Integer>();
		List<Integer> second = new ArrayList<Integer>();

		int middle = (int) Math.ceil((double) input.size() / 2);
		for (int i = 0; i < middle; i++) {
			first.add(input.get(i));
		}
		for (int i = middle; i < input.size(); i++) {
			second.add(input.get(i));
		}		
		return mergesort(pertition(first), pertition(second));
	}
	
	private Iterable<Integer> mergesort(Iterable<Integer> first,
			Iterable<Integer> second) {
		
		Iterable<Integer> all = Iterables.mergeSorted(
				ImmutableList.of(first, second), Ordering.natural());
		
		return all;
	}


}