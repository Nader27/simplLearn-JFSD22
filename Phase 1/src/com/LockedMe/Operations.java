package com.LockedMe;

import java.io.File;

import static com.LockedMe.Algorithms.*;

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

    public static boolean delete(String fileName, File rootDirectory) {
        File newfile = new File(rootDirectory.getAbsolutePath() + File.separator + fileName);
        try {
            return newfile.delete();
        } catch (Exception e) {
            return false;
        }
    }
}
