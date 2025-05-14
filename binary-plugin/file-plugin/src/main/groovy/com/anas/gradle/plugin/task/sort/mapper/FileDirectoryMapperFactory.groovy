package com.anas.gradle.plugin.task.sort.mapper

import com.anas.gradle.plugin.type.SortAlgorithm
import org.gradle.api.Project

class FileDirectoryMapperFactory {

    static final String SORT_ALGORITHM_PROPERTY_NAME = "tasks.files.sortAlgorithm"

    static FileDirectoryMapper get(Project project) {
        if (!project.hasProperty(SORT_ALGORITHM_PROPERTY_NAME)) {
            return new FileDirectoryDateMapper()
        }

        def sortAlgorithm = SortAlgorithm.fromValue(project.property(SORT_ALGORITHM_PROPERTY_NAME))
        switch (sortAlgorithm) {
            case SortAlgorithm.EXTENSION:
                return new FileDirectoryExtensionMapper()
            case SortAlgorithm.ALPHABET:
                return new FileDirectoryAlphabetMapper()
            default:
                return new FileDirectoryDateMapper()
        }
    }
}