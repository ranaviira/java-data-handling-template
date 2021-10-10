package com.epam.izh.rd.online.repository;

import java.io.*;
import java.nio.file.Files;


public class SimpleFileRepository implements FileRepository {
    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {
        long count = 0;
        File directory = new File("src/main/resources/" + path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    count++;
                }
                if (file.isDirectory()) {
                    count += countFilesInDirectory(path + "/" + file.getName());
                }
            }
        }
        return count;
    }

    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {
        long count = 1;
        File directory = new File("src/main/resources/" + path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    count += countDirsInDirectory(path + "/" + file.getName());
                }
            }
        }
        return count;
    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        File folder2 = new File(to);
        if(!folder2.getParentFile().exists()){
            folder2.getParentFile().mkdir();
        }

        File folder1 = new File(from);
        if((folder1.getName().endsWith(".txt"))){
            try {
                Files.copy(folder1.toPath(), folder2.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



//        File[] listOfFiles = folder.listFiles();
//        if (listOfFiles == null) {
//            for (File file : listOfFiles) {
//                if (file.getName().endsWith(".txt")) {
//                    try {
//                        Files.copy(file.toPath(), Paths.get(to + "/" + file.getName()));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

    }


    /**
     * Метод создает файл на диске с расширением txt
     *
     * @param path путь до нового файла
     * @param name имя файла
     * @return был ли создан файл
     */
    @Override
    public boolean createFile(String path, String name) {

        File file = new File(getClass().getResource("/").getPath() + path + "/" + name);
        File dir = new File(getClass().getResource("/").getPath() + path);

        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            if (!file.exists())
                return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        File file = new File("src/main/resources/" + fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
