package com.markkamau

import java.io.BufferedWriter
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.Collections
import java.util.Scanner

val FILENAME = "filename"
val EXTENSION = "extension"

fun Path.copyFileTo(target: Path) {
    Files.copy(this, target, StandardCopyOption.REPLACE_EXISTING)
}

fun Path.deleteFile() = Files.deleteIfExists(this)

fun Path.moveFileTo(target: Path) {
    Files.move(this, target, StandardCopyOption.REPLACE_EXISTING)
}

fun Path.getFileNameAndExtension(): Map<String, String> {
    val result = HashMap<String, String>()
    result.put(FILENAME, this.fileName.toString().split("\\.".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[0])
    result.put(EXTENSION, this.fileName.toString().split("\\.".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[1])
    return result
}

fun Path.readFileAsLines(): MutableList<String> {
    var lines = Collections.emptyList<String>()

    Files.newBufferedReader(this).use { reader ->
        lines = reader.readLines() as ArrayList<String>
    }

    return lines
}

fun Path.writeFileByLine(content: List<String>, append: Boolean = false) {
    val fileWriter = FileWriter(this.toString(), append)

    BufferedWriter(fileWriter).use { writer ->
        for (s in content) {
            writer.append(s, 0, s.length)
            writer.newLine()
        }
    }
}

fun Path.readFileAsBytes(): ByteArray? = Files.readAllBytes(this)

fun Path.writeFileByBytes(content: ByteArray) = Files.write(this, content)

fun Path.readFileTokens(delimiter: String = " "): List<String> {
    val tokens = mutableListOf<String>()
    val reader = Files.newBufferedReader(this)

    Scanner(reader).use { scanner ->
        scanner.useDelimiter(delimiter)
        while (scanner.hasNext()) {
            tokens.add(scanner.next())
        }
        return tokens
    }

}
