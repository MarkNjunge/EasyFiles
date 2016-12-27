# EasyFiles
A simple way of performing common file interactions.

The library can:

1. Copy, move or delete a file.

2. Read and write a file by line.

3. Read and write the contents of a file in bytes.

4. Read the content of a file in tokens.

#Usage
Once imported,
```Java
EasyFiles ef = new EasyFiles();

ef.copyFile(source, target);
List<String> content = ef.readFileAsLines(source);
// ...
```

#License
EasyFiles is licensed under Apache 2.0 License.
