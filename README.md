# EasyFiles
A library for simplifying common file interactions.

The library can:

1. Copy, move or delete a file.

2. Read and write a file by line.

3. Read and write the contents of a file in bytes.

4. Read the content of a file in tokens.

# Usage
**Requires Java 7+**
```Java
Path source = Paths.get("source.txt");
Path target = Paths.get("target.txt");

// Initializer
EasyFiles easyFiles = new EasyFiles();

// Copy File
easyFiles.copyFile(source, target, new EasyFiles.ActionListeners() { // Success listener
    @Override
    public void actionSuccessful() {
        System.out.println("Copy successful!");
    }
});

// Delete file
easyFiles.deleteFile(source, () -> { // lambda expressions for Java 8
    System.out.println("Delete successful!");
);

// Move file
easyFiles.moveFile(source, target, null); // No listener

// Getting filename and extension
Map<String, String> map = easyFiles.getFileNameAndExtension(source, null);
map.get(EasyFiles.FILENAME);
map.get(EasyFiles.EXTENSION);

// Read and write files by line
List<String> contentLines = easyFiles.readFileAsLines(source);
easyFiles.writeFileByLine(target, contentLines, true, null);

// Read and write files by bytes
byte[] contentBytes = easyFiles.readFileAsBytes(source);
easyFiles.writeFileByBytes(target, contentBytes, null);

// Read file using tokens
List<String> tokens = easyFiles.readFileTokens(source, "delimiter");
```

# License
EasyFiles is licensed under Apache 2.0 License.
