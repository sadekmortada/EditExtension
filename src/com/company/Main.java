package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nInput Folder/File path. (ex: D:/thumbnails.exe)\n");
        String path=new Scanner(System.in).next();
        try {
            File directory = new File(path);
            File[] directoryContents = directory.listFiles();
            for (File file : directoryContents)
                if(file.isFile()){
                    String fileName=file.getName();
                    int index = fileName.lastIndexOf('.');
                    if(fileName.substring(index).equals(".cache"))
                        file.renameTo(new File(file.getName().substring(0, index) + ".jpg"));
                }
        }
        catch(Exception e){
            System.out.println("\nDirectory doesn't exist..");
        }
    }
}
