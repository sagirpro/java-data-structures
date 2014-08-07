package merge;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * @author Sagiruddin Mondal <sagir.pro@gmail.com>
 */
public class MergeSort {

	/**
	 * Main method.
	 * @param args
	 */
	
	public static void main(String[] args) {

		MergeSort app = new MergeSort();

		// provide any integer input inside bracket sheparating by comma
		List<Integer> input = Lists.newArrayList(4, 3, 543, 112, 23, 1);

		// Before sort
		System.out.println("Input =" + input);
		
		// sending to sort
		Iterable<Integer> sorted = app.pertition(input);

		// After sort
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