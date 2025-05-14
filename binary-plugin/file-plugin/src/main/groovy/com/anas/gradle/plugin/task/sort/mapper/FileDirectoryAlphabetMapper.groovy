package com.anas.gradle.plugin.task.sort.mapper

class FileDirectoryAlphabetMapper implements FileDirectoryMapper {

    @Override
    String mapToDirectoryName(File file) {
        return file.name[0]
    }
}