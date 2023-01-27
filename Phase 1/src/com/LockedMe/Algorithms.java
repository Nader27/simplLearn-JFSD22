package com.LockedMe;

public class Algorithms {

    static void bubbleSort(String[] arr, int n) {
        String temp;
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    static int binarySearch(String[] v, String To_Find) {
        int lo = 0, hi = v.length - 1;
        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;
            if (v[mid].compareTo(To_Find) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (v[lo].equals(To_Find)) {
            return lo;
        } else if (v[hi].equals(To_Find)) {
            return hi;
        } else {
            return -1;
        }
    }
}
