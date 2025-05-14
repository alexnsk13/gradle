package com.anas.gradle.plugin.task.clean


import org.gradle.api.tasks.Delete

import static com.anas.gradle.plugin.common.Constants.GROUP

class CleanTask extends Delete {

    static final String TASK_NAME = "clean"

    CleanTask() {
        group = GROUP
        description = "Clean build directory"
        delete project.layout.buildDirectory
    }
}