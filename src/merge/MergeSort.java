package merge;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;


public class MergeSort {
    public static void main(String[] args) {

        List<Integer> first  = Lists.newArrayList(1, 4, 3);
        Collections.sort(first);
        // Note that each input list has to be sorted already!
        List<Integer> second = Lists.newArrayList(2, 4, 3, 7, 6);
        Collections.sort(second);
        Iterable<Integer> all = Iterables.mergeSorted(
            ImmutableList.of(first, second), Ordering.natural());
        System.out.println(Joiner.on(", ").join(all));
    }
} 