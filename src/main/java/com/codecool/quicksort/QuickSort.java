package com.codecool.quicksort;

import java.util.Collections;
import java.util.List;


public class QuickSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
        if (toSort == null) {
            throw new IllegalArgumentException("Array is null.");
        }
        quicksort(toSort, 0, toSort.size()-1);
    }


    private void quicksort(List<Integer> toSort, int left, int right) {
        if (left >= right) {
            return;
        }
        int indexOfPivot = partition(toSort, left, right);
        quicksort(toSort, left, indexOfPivot - 1);
        quicksort(toSort, indexOfPivot + 1, right);
    }

    private int partition(List<Integer> toSort, int left, int right) {
        int pivot = toSort.get((left + right) / 2);
        while (left < right) {
            while (toSort.get(left) < pivot) {
                left++;
            }
            while (toSort.get(right) > pivot) {
                right--;
            }
            Collections.swap(toSort, left, right);

            if (toSort.get(left) == pivot) {
                left++;
            }
        }
        return left;
    }
}