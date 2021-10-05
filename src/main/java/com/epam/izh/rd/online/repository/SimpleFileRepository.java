package com.epam.izh.rd.online.repository;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleFileRepository implements FileRepository {


    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {


        return countFilesInDirectory(path);
    }


    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {
        return 0;
    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        copyTXTFiles(from, to);

        return;
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

        Path path1 = Paths.get(path + "/" + name);
        Path path2 = Paths.get(path);
        try {
            if (!Files.exists(path2)) {
                Files.createDirectory(path2);
            }
        } catch (IOException e) {
            return false;
        }
        try {
            if (!Files.exists(path1)) {
                Files.createFile(path1);
            }
        } catch (IOException e) {
            return false;
        }
        return Files.exists(path1);
    }


    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        try {
            FileReader fileReader = new FileReader(readFileFromResources(fileName));
            return fileReader.getEncoding();
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
