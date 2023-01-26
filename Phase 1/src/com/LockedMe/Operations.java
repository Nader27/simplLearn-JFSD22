package com.LockedMe;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Operations {

    public static String[] list(File rootDirectory) {
        String[] arr = rootDirectory.list();
        if (arr != null) {
            bubbleSort(arr, arr.length);
            return arr;
        }
        return new String[0];
    }

    public static boolean add(String fileName, File rootDirectory) {
        File newfile = new File(rootDirectory.getAbsolutePath() + File.separator + fileName);
        try {
            return newfile.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }

    public static int search(String fileName, File rootDirectory) {
        String[] array = rootDirectory.list();
        bubbleSort(array, array.length);
        return binarySearch(array, fileName);
    }

    private static void bubbleSort(String[] arr, int n) {
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

    public static boolean delete(String fileName, File rootDirectory) {
        File newfile = new File(rootDirectory.getAbsolutePath() + File.separator + fileName);
        try {
            return newfile.delete();
        } catch (Exception e) {
            return false;
        }
    }
}
