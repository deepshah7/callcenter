package com.callcenter.schedular;

import com.callcenter.external.WaveFileDirectoryPathFinder;
import com.callcenter.reader.WaveFileReader;
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
        final String waveFileDirectoryPath = waveFileDirectoryPathFinder.getWaveFileDirectory();
        final File waveFileDirectory = new File(waveFileDirectoryPath);
        if (!waveFileDirectory.isDirectory()) {
            logger.error("Invalid registery entry the path: " + waveFileDirectory.getAbsolutePath()
                    + " points to a file not a directory");
            return;
        }

        readWaveFiles(waveFileDirectory);
    }

    private void readWaveFiles(File waveFileDirectory) {
        logger.info("Starting to read the files from the path");
        for (String fileName : waveFileDirectory.list()) {
            final File waveFile = new File(fileName);
            waveFileReader.read(waveFile);
            waveFile.delete();
        }
    }

    public void setWaveFileDirectoryPathFinder(final WaveFileDirectoryPathFinder waveFileDirectoryPathFinder) {
        this.waveFileDirectoryPathFinder = waveFileDirectoryPathFinder;
    }

    public void setWaveFileReader(final WaveFileReader waveFileReader) {
        this.waveFileReader = waveFileReader;
    }
}
