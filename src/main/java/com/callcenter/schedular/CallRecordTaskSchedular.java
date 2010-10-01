package com.callcenter.schedular;

import com.callcenter.external.WaveFileDirectoryPathFinder;
import com.callcenter.external.model.Directory;
import com.callcenter.reader.WaveFileReader;
import com.callcenter.util.Constants;
import com.callcenter.wavefile.processor.WaveFileProcessor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component("callRecordTaskSchedular")
public class CallRecordTaskSchedular {

    private static final Logger logger = Logger.getLogger(CallRecordTaskSchedular.class);

    @Autowired
    private WaveFileDirectoryPathFinder waveFileDirectoryPathFinder;

    @Autowired
    private WaveFileProcessor waveFileProcessor;

    public void checkIfCallRecordAvailable() {
        final Directory waveFileDirectory = waveFileDirectoryPathFinder.getWaveFileDirectory();
        logger.info("Starting to read the files from the path");
        for (com.callcenter.external.model.File waveFile : waveFileDirectory.list()) {
            logger.info("#######Start processing the wave file######");
            waveFileProcessor.process(waveFile);
            logger.info("#######End processing the wave file######");
        }
    }

    public void setWaveFileDirectoryPathFinder(final WaveFileDirectoryPathFinder waveFileDirectoryPathFinder) {
        this.waveFileDirectoryPathFinder = waveFileDirectoryPathFinder;
    }

    public void setWaveFileProcessor(WaveFileProcessor waveFileProcessor) {
        this.waveFileProcessor = waveFileProcessor;
    }
}
