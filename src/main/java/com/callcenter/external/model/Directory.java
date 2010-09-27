package com.callcenter.external.model;

import com.callcenter.util.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class Directory {

    private File file;

    public Directory(final String directoryPath) {
        file = new File(directoryPath);
    }

    public String getAbsolutePath() {
        return file.getAbsolutePath();
    }

    public boolean isValid() {
        return file.isDirectory();
    }

    public List<com.callcenter.external.model.File> list() {
        final java.io.File[] files = file.listFiles();
        final List<com.callcenter.external.model.File> enhancedFiles = new ArrayList<com.callcenter.external.model.File>();
        for(java.io.File file : files) {
            enhancedFiles.add(new com.callcenter.external.model.File(file));
        }
        return enhancedFiles;
    }
}
