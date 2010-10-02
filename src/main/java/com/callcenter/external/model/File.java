package com.callcenter.external.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.callcenter.wavefile.processor.WaveFileNamingStrategy;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Configurable
public class File {

    private java.io.File originalFile;

    private java.io.File processedFile;

    @Autowired
    private WaveFileNamingStrategy waveFileNamingStrategy;

    public File(java.io.File originalFile) {

        this.originalFile = originalFile;
    }

    public void beforeProcess() {
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

    public void setWaveFileNamingStrategy(WaveFileNamingStrategy waveFileNamingStrategy) {
        this.waveFileNamingStrategy = waveFileNamingStrategy;
    }

}
