# EasyFiles
A simple way of performing common file interactions.

The library can:

1. Copy, move or delete a file.

2. Read and write a file by line.

3. Read and write the contents of a file in bytes.

4. Read the content of a file in tokens.

#Usage
```Java
Path source = Paths.get("source.txt");
Path target = Paths.get("target.txt");

EasyFiles easyFiles = new EasyFiles();

easyFiles.copyFile(source, target);
easyFiles.deleteFile(source);
easyFiles.moveFile(source, target);

List<String> contentLines = easyFiles.readFileAsLines(source);
easyFiles.writeFileByLine(target, contentLines, true);

byte[] contentBytes = easyFiles.readFileAsBytes(source);
easyFiles.writeFileByBytes(target, contentBytes);

List<String> tokens = easyFiles.readFileTokens(source, null);
```

#License
EasyFiles is licensed under Apache 2.0 License.
