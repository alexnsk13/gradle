package com.anas.gradle.plugin

import com.anas.gradle.plugin.task.clean.CleanTask
import com.anas.gradle.plugin.task.sort.SortTask
import groovy.transform.CompileStatic
import org.gradle.api.Plugin
import org.gradle.api.Project

@CompileStatic
class FilePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.tasks.register(CleanTask.TASK_NAME, CleanTask)
        project.tasks.register(SortTask.TASK_NAME, SortTask)
    }
}