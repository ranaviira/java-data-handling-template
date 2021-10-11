package com.epam.izh.rd.online.repository;

import java.io.*;
import java.nio.file.Files;

public class SimpleFileRepository implements FileRepository {

    @Override
    public long countFilesInDirectory(String path) {
        long countFiles = 0;
        File directory = new File("src/main/resources/" + path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    countFiles++;
                }
                if (file.isDirectory()) {
                    countFiles += countFilesInDirectory(path + "/" + file.getName());
                }
            }
        }
        return countFiles;
    }

    @Override
    public long countDirsInDirectory(String path) {
        long countDirectory = 1;
        File directory = new File("src/main/resources/" + path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    countDirectory += countDirsInDirectory(path + "/" + file.getName());
                }
            }
        }
        return countDirectory;
    }

    @Override
    public void copyTXTFiles(String from, String to) {
        File folderTo = new File(to);
        if (!folderTo.getParentFile().exists()) {
            folderTo.getParentFile().mkdir();
        }
        File fileFrom = new File(from);
        if ((fileFrom.getName().endsWith(".txt"))) {
            try {
                Files.copy(fileFrom.toPath(), folderTo.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean createFile(String path, String name) {

        File file = new File(getClass().getResource("/").getPath() + path + "/" + name);
        File directory = new File(getClass().getResource("/").getPath() + path);

        if (!directory.exists()) {
            directory.mkdir();
        }
        try {
            if (!file.exists())
                return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String readFileFromResources(String fileName) {
        File file = new File("src/main/resources/" + fileName);
        try {
            BufferedReader fileRead = new BufferedReader(new FileReader(file));
            return fileRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
