package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES: ");

        for(File file : files) {
            System.out.println(file);
        }
        sc.close();
    }
}