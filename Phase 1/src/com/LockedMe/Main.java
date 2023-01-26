package com.LockedMe;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static File rootDirectory = null;

    private static final Scanner scanner = new Scanner(System.in);

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    private static void clearScanner() {
        scanner.nextLine();
    }

    private static void selectRootDirectory() {
        do {
            if (rootDirectory != null)
                System.out.println("Directory path is not valid!!");
            System.out.println("Enter The Root Directory:");
            String directory = scanner.nextLine();
            try {
                rootDirectory = new File(directory);
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } while (!rootDirectory.isDirectory());
    }

    private static int mainMenuDisplay() {
        int selectedOption = 0;
        while (selectedOption < 1 || selectedOption > 6) {
            clearConsole();
            System.out.println("Hello Welcome to LockedMe");
            System.out.println("Developed by: Nader Labib\n");
            System.out.println("Please select any of the below options to proceed:\n");
            System.out.println("(1) List files");
            System.out.println("(2) Create a new file");
            System.out.println("(3) Delete an existing file");
            System.out.println("(4) Search for a file");
            System.out.println("(5) Change Root Directory");
            System.out.println("(6) Exit Application");
            try {
                selectedOption = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        clearScanner();
        return selectedOption;
    }

    public static void main(String[] args) {
        selectRootDirectory();
        boolean exit = false;
        while (!exit) {
            switch (mainMenuDisplay()) {
                case 1:
                    String [] fileList = Operations.list(rootDirectory);
                    for (int i = 0; i < fileList.length; i++) {
                        System.out.println("(" + (i + 1) + ") " + fileList[i]);
                    }
                    System.out.print("Press enter to continue.....");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Enter file Name :");
                    String newFileName = scanner.nextLine();
                    if (Operations.add(newFileName, rootDirectory)) {
                        System.out.println("File created successfully !!");
                        scanner.nextLine();
                    } else {
                        System.out.println("File failed to be created !!");
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("Enter file Name :");
                    String deleteFileName = scanner.nextLine();
                    if (Operations.delete(deleteFileName, rootDirectory)) {
                        System.out.println("File is deleted !!");
                        scanner.nextLine();
                    } else {
                        System.out.println("File is not deleted !!");
                        scanner.nextLine();
                    }
                    break;
                case 4:
                    System.out.println("Enter file Name :");
                    String fileName = scanner.nextLine();
                    int result = Operations.search(fileName, rootDirectory);
                    if (result >= 0) {
                        System.out.println("File is found at "+(result+1)+" !!");
                        scanner.nextLine();
                    } else {
                        System.out.println("File is not exist !!");
                        scanner.nextLine();
                    }
                    break;
                case 5:
                    rootDirectory = null;
                    selectRootDirectory();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Not Valid option Selected");
                    break;
            }
        }

        System.out.println("Thanks for using LockedMe");
        System.out.println("Goodbye!!");
    }
}