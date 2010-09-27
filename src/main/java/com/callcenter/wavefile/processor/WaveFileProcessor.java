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

    public void process(File waveFile) {
        waveFile.beforeProcess();
        waveFileReader.read(waveFile);
        waveFile.postProcess();

    }
}
