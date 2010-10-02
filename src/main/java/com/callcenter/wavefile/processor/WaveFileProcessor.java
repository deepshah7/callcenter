package com.callcenter.wavefile.processor;

import com.callcenter.external.model.File;
import com.callcenter.reader.WaveFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WaveFileProcessor {

    @Autowired
    private WaveFileReader waveFileReader;

    @Autowired
    private WaveFileNamingStrategy waveFileNamingStrategy;

    public void process(File waveFile) {
        waveFile.beforeProcess(waveFileNamingStrategy);
        waveFileReader.read(waveFile);
        waveFile.postProcess();

    }

    public void setWaveFileReader(WaveFileReader waveFileReader) {
        this.waveFileReader = waveFileReader;
    }

    public void setWaveFileNamingStrategy(WaveFileNamingStrategy waveFileNamingStrategy) {
        this.waveFileNamingStrategy = waveFileNamingStrategy;
    }
}
