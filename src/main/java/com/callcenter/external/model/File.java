package com.callcenter.external.model;

import com.callcenter.wavefile.processor.WaveFileNamingStrategy;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class File {

    private java.io.File originalFile;

    private java.io.File processedFile;


    public File(java.io.File originalFile) {

        this.originalFile = originalFile;
    }

    public void beforeProcess(final WaveFileNamingStrategy waveFileNamingStrategy) {
        processedFile = new java.io.File(waveFileNamingStrategy.generateNewFileName(
            originalFile.getName()));
        originalFile.renameTo(processedFile);
    }

    public String getName() {
        return processedFile.getName();
    }

    public java.io.File getProcessedFile() {
        return processedFile;
    }

    public void postProcess() {
    }
}
