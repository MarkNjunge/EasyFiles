# EasyFiles
A library for simplifying common file interactions.

The library can:

1. Copy, move or delete a file.

2. Read and write a file by line.

3. Read and write the contents of a file in bytes.

4. Read the content of a file in tokens.

5. Get filename and extension

# Usage
**Requires Java 7+**
```Java
Path source = Paths.get("source.txt");
Path target = Paths.get("target.txt");

// Copy File
EasyFiles.copyFile(source, target, new EasyFiles.ActionListeners() { // Action Successful listener
    @Override
    public void actionSuccessful() {
        System.out.println("Copy successful!");
    }
});

// Delete file
EasyFiles.deleteFile(source, () -> System.out.println("Delete successful!"));

// Move file
EasyFiles.moveFile(source, target, null); // No listener

// Getting filename and extension
Map<String, String> map = EasyFiles.getFileNameAndExtention(source);
map.get(EasyFiles.FILENAME);
map.get(EasyFiles.EXTENSION);

// Read and write files by line
List<String> contentLines = EasyFiles.readFileAsLines(source);
EasyFiles.writeFileByLine(target, contentLines, true, null);

// Read and write files by bytes
byte[] contentBytes = EasyFiles.readFileAsBytes(source);
EasyFiles.writeFileByBytes(target, contentBytes, null);

// Read file using tokens
List<String> tokens = EasyFiles.readFileTokens(source, "delimiter");
```     

# License
EasyFiles is licensed under Apache 2.0 License.
