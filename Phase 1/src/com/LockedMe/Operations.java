package com.LockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Operations {

    public static List<File> list(File rootDirectory){
        List<File> directories = Arrays.asList(rootDirectory.listFiles());
        sort(directories);
        return directories;
    }

    private static void sort(List<File> directory){
        directory.sort(Comparator.comparing(File::getName));
    }

    public static boolean add(String fileName,File rootDirectory) {
        File newfile = new File(rootDirectory.getAbsolutePath()+File.separator+fileName);
        try {
            return newfile.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean search(String fileName, File rootDirectory) {
        File newfile = new File(rootDirectory.getAbsolutePath()+File.separator+fileName);
        try {
            return newfile.exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean delete(String fileName, File rootDirectory) {
        File newfile = new File(rootDirectory.getAbsolutePath()+File.separator+fileName);
        try {
            return newfile.delete();
        } catch (Exception e) {
            return false;
        }
    }
}
