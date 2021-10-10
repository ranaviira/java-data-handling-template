package com.epam.izh.rd.online;


import java.io.File;
import java.io.IOException;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {



    static public long searchFile(String path) {
        long count = 0;
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.isFile()) {
                    count++;
                }
                if (file.isDirectory()) {
                    count += searchFile(file.getPath());
                }
            }
        }  return count;
    }

    public static void main(String[] args) throws IOException {
        File folder = new File("fileRepository/source/TestFileToCopy.txt");
        File[] listOfFiles = folder.listFiles();


        System.out.println(listOfFiles[0]);
    }


}


