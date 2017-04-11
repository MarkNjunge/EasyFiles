package com.markkamau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 * A simple way of performing common file interactions
 *
 * @author Mark Kamau
 * @version 1.2.1
 */
public class EasyFiles {

    public static final String FILENAME = "filename";
    public static final String EXTENSION = "extension";

    interface ActionListeners {
        void actionSuccessful();
    }

    /**
     * Copies a file from one location to another
     *
     * @param source   The file that is to be copied
     * @param target   The target location and name of the new file
     * @param listener A listener for a successful operation, may be null
     */
    public static void copyFile(Path source, Path target, ActionListeners listener) {
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            if (listener != null) {
                listener.actionSuccessful();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a file if it exists
     *
     * @param source   The file to be deleted
     * @param listener A listener for a successful operation, may be null
     */
    public static void deleteFile(Path source, ActionListeners listener) {
        try {
            Files.deleteIfExists(source);
            if (listener != null) {
                listener.actionSuccessful();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Moves a file from one location to another
     *
     * @param source   The file that is to be moved
     * @param target   The target location and name of the new file
     * @param listener A listener for a successful operation, may be null
     */
    public static void moveFile(Path source, Path target, ActionListeners listener) {
        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            if (listener != null){
                listener.actionSuccessful();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the filename and extension
     *
     * @param source   The file to be inspected
     * @return Map containing filename and extension, may be null
     */
    public static Map<String, String> getFileNameAndExtention(Path source) {
        try {
            Map<String, String> result = new HashMap<>();
            result.put(FILENAME, source.getFileName().toString().split("\\.")[0]);
            result.put(EXTENSION, source.getFileName().toString().split("\\.")[1]);
            return result;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads a file by line
     *
     * @param source The file to be read
     * @return The contents of the file
     */
    public static List<String> readFileAsLines(Path source) {
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
     *
     * @param target   The file to be written to
     * @param content  The content to be written to the file, passed a List
     * @param listener A listener for a successful operation, may be null
     * @param append   Whether or not the content should add to what is already there or replace it
     */
    public static void writeFileByLine(Path target, List<String> content, Boolean append, ActionListeners listener) {
        try {
            FileWriter fileWriter = new FileWriter(target.toString(), append);

            try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
                for (String s : content) {
                    writer.append(s, 0, s.length());
                    writer.newLine();
                }
                if (listener != null) {
                    listener.actionSuccessful();
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
     *
     * @param source The file to be read
     * @return The data in the file
     */
    public static byte[] readFileAsBytes(Path source) {
        try {
            return Files.readAllBytes(source);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Writes a to a file in bytes
     *
     * @param target   The file to be written to
     * @param content  The content to be written
     * @param listener A listener for a successful operation, may be null
     */
    public static void writeFileByBytes(Path target, byte[] content, ActionListeners listener) {
        try {
            Files.write(target, content);
            if (listener != null) {
                listener.actionSuccessful();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a file and separates tokens
     *
     * @param source    The file to be read
     * @param delimiter The delimiter, that is,  the separator between tokens
     * @return The tokens read from the file
     */
    public static List<String> readFileTokens(Path source, String delimiter) {
        List<String> tokens = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(source);

            try (Scanner scanner = new Scanner(reader)) {
                if (delimiter != null) {
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