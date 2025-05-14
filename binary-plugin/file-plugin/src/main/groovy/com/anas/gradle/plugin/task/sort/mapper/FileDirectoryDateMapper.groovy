package com.anas.gradle.plugin.task.sort.mapper


import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class FileDirectoryDateMapper implements FileDirectoryMapper {

    @Override
    String mapToDirectoryName(File file) {
        def attrs = Files.readAttributes(file.toPath(), BasicFileAttributes)
        def formatter = DateTimeFormatter.ofPattern("MM-YYYY")
        def date = attrs.creationTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        return formatter.format(date)
    }
}
