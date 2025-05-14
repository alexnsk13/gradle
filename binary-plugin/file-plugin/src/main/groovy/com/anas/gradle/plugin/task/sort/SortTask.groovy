package com.anas.gradle.plugin.task.sort

import com.anas.gradle.plugin.task.clean.CleanTask
import com.anas.gradle.plugin.task.sort.mapper.FileDirectoryMapperFactory
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files

import static com.anas.gradle.plugin.common.Constants.GROUP

@Slf4j
@CompileStatic
class SortTask extends DefaultTask {

    static final String TASK_NAME = "sort"

    SortTask() {
        group = GROUP
        description = "Sorts files in given directory into build.files subdirectories based on the sorting type [creationDate,extension]"
        dependsOn project.tasks.named(CleanTask.TASK_NAME)
    }

    @TaskAction
    void apply() {
        log.info("==== Sorting Files ====")

        def dirNameMapper = FileDirectoryMapperFactory.get(project)
        def fileDir = project.property("tasks.files.folder")
        def sourceDir = new File("${project.rootDir.path}/$fileDir")
        def outputDir = project.layout.buildDirectory.dir("$fileDir").get().asFile

        sourceDir.listFiles().each {
            def targetDir = new File(outputDir, dirNameMapper.mapToDirectoryName(it))
            targetDir.mkdirs()
            def targetPath = targetDir.toPath().resolve(it.name)

            Files.copy(it.toPath(), targetPath)
        }

        log.info("");
        log.info("=======================");
    }
}