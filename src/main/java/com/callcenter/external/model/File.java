package com.callcenter.external.model;

import com.callcenter.wavefile.processor.WaveFileNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Configurable
public class File {

    private java.io.File file;

    private java.io.File fileToProcess;

    @Autowired
    private WaveFileNamingStrategy waveFileNamingStrategy;

    public File(java.io.File file) {
        this.file = file;
    }

    public void beforeProcess() {
        fileToProcess = new java.io.File(waveFileNamingStrategy.generateNewFileName(
                file.getName()));

        file.renameTo(fileToProcess);
    }

    public String getName() {
        return fileToProcess.getName();
    }

    public java.io.File getFileToProcess() {
        return fileToProcess;
    }

    public void postProcess() {
    }

    public void setWaveFileNamingStrategy(WaveFileNamingStrategy waveFileNamingStrategy) {
        this.waveFileNamingStrategy = waveFileNamingStrategy;
    }
}
