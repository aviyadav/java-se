package com.javacreed.examples.concurrency.utils;

import java.io.File;

public class FilePath {
    private FilePath() {}
    
    public static final File TEST_DIR = new File(System.getProperty("user.home"), "Google Drive").getAbsoluteFile();
}
