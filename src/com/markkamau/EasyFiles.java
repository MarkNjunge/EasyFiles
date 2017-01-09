package com.markkamau;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A simple way of performing common file interactions
 * @author  Mark Kamau
 * @version 1.0
 */
public class EasyFiles {

    /**
     * Copies a file from one location to another
     * @param source The file that is to be copied
     * @param target The target location and name of the new file
     */
    public void copyFile(Path source, Path target) {
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a file if it exists
     * @param source The file to be deleted
     */
    public void deleteFile(Path source){
        try {
            Files.deleteIfExists(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Moves a file from one location to another
     * @param source The file that is to be moved
     * @param target The target location and name of the new file
     */
    public void moveFile(Path source, Path target){
        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a file by line
     * @param source The file to be read
     * @return The contents of the file
     */
    public List<String> readFileAsLines(Path source) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(source)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Write a file line by line
     * @param target The file to be written to
     * @param content The content to be written to the file, passed a List
     * @param append Whether or not the content should add to what is already there or replace it
     */
    public void writeFileByLine(Path target, List<String> content, Boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(target.getFileName().toString(), append);

            try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
                for (String s : content) {
                    writer.append(s, 0, s.length());
                    writer.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a file in bytes
     * @param source The file to be read
     * @return The data in the file
     */
    public byte[] readFileAsBytes(Path source) {
        try {
            return Files.readAllBytes(source);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Writes a to a file in bytes
     * @param target The file to be written to
     * @param content The content to be written
     */
    public void writeFileByBytes(Path target, byte[] content) {
        try {
            Files.write(target, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a file and separates tokens
     * @param source The file to be read
     * @param delimiter The delimiter, that is,  the separator between tokens
     * @return The tokens read from the file
     */
    public List<String> readFileTokens(Path source, String delimiter) {
        List<String> tokens = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(source);

            try (Scanner scanner = new Scanner(reader)) {
                if (delimiter != null){
                    scanner.useDelimiter(delimiter);// Default is spaces
                }
                while (scanner.hasNext()) {
                    tokens.add(scanner.next());
                }
                return tokens;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}