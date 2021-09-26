package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\nEnter Folder path. (ex: C:/newFolder/thumbnails)\n");
        String path=scanner.next();
        try {
            File directory = new File(path);
            System.out.println("\nEnter the type you want to change. (ex: exe, png, etc..)\n");
            String oldType=scanner.next();
            System.out.println("\nEnter the new type.");
            String newType=scanner.next();
            File[] directoryContents = directory.listFiles();
            for (File file : directoryContents)
                if(file.isFile()){
                    String fileName=file.getName();
                    int index = fileName.lastIndexOf('.');
                    if(fileName.substring(index).equals("."+oldType))
                        file.renameTo(new File(file.getName().substring(0, index) + "."+newType));
                }
            System.out.println("\nChanges are made, check the application directory for the renamed files.");
        }
        catch(Exception e){
            System.out.println("\nExecution failed!");
        }
    }
}
