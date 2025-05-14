package com.anas.gradle.plugin.type

enum SortAlgorithm {
    EXTENSION("extension"),
    CREATION_DATE("creationDate"),
    ALPHABET("alphabet")

    private final String name

    SortAlgorithm(String name) {
        this.name = name
    }

    String getName() {
        return name
    }

    static SortAlgorithm fromValue(String value) {
        for (SortAlgorithm algorithm : values()) {
            if (algorithm.name.equalsIgnoreCase(value)) {
                return algorithm
            }
        }
        throw new IllegalArgumentException("Invalid sortAlgorithm provided: $value")
    }
}