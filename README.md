# EasyFiles
A simple way of performing common file interactions.

The library can:

1. Copy, move or delete a file.

2. Read and write a file by line.

3. Read and write the contents of a file in bytes.

4. Read the content of a file in tokens.

# Usage
```Java
Path source = Paths.get("source.txt");
Path target = Paths.get("target.txt");

EasyFiles.copyFile(source, target);
EasyFiles.deleteFile(source);
EasyFiles.moveFile(source, target);

Map<String, String> map = EasyFiles.getFileNameAndExtension(source);
map.get(EasyFiles.FILENAME);
map.get(EasyFiles.EXTENSION);

List<String> contentLines = EasyFiles.readFileAsLines(source);
EasyFiles.writeFileByLine(target, contentLines, true);

byte[] contentBytes = easyFiles.readFileAsBytes(source);
EasyFiles.writeFileByBytes(target, contentBytes);

String delimiter = ","; //Default is whitespace
List<String> tokens = EasyFiles.readFileTokens(source, delimiter);
```

#License
EasyFiles is licensed under Apache 2.0 License.
