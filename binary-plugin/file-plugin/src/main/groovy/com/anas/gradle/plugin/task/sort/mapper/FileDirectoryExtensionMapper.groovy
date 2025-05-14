package com.anas.gradle.plugin.task.sort.mapper

class FileDirectoryExtensionMapper implements FileDirectoryMapper {

    @Override
    String mapToDirectoryName(File file) {
        return file.name.tokenize(".").last()
    }
}