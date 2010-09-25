package com.callcenter.schedular;

import com.callcenter.external.WaveFileDirectoryPathFinder;
import com.callcenter.external.model.Directory;
import com.callcenter.reader.WaveFileReader;
import com.callcenter.util.Constants;
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
    private WaveFileReader waveFileReader;

    public void checkIfCallRecordAvailable() {
        final Directory waveFileDirectory = waveFileDirectoryPathFinder.getWaveFileDirectory();
        logger.info("Starting to read the files from the path");
        for (File waveFile : waveFileDirectory.list()) {
            logger.info("#######Start processing the wave file######");
            waveFileReader.read(waveFile);
            logger.info("#######End processing the wave file######");
            waveFile.delete();
            logger.info("#######Deleting the file wave file######");
        }
    }

    public void setWaveFileDirectoryPathFinder(final WaveFileDirectoryPathFinder waveFileDirectoryPathFinder) {
        this.waveFileDirectoryPathFinder = waveFileDirectoryPathFinder;
    }

    public void setWaveFileReader(final WaveFileReader waveFileReader) {
        this.waveFileReader = waveFileReader;
    }
}
