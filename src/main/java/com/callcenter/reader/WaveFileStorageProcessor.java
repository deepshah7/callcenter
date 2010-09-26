package com.callcenter.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.mapper.WaveFileToCallRecordMapper;
import com.callcenter.reader.model.WaveFile;

@Component
public class WaveFileStorageProcessor {
    private static final Logger logger = Logger.getLogger(WaveFileReader.class);
    private String wavStorageDir;

    @Autowired
    private WaveFileToCallRecordMapper waveFileToCallRecordMapper;

    public void process(WaveFile waveFile, File file) {
        try {
            File newWaveFileName = moveWavFileToDestinationDirectory(file);
            persistCallRecord(waveFile, newWaveFileName);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void persistCallRecord(WaveFile waveFile, File newWaveFileName) {
        CallRecord callRecord = waveFileToCallRecordMapper.mapToCallRecord(waveFile, newWaveFileName.getName());
        callRecord.persist();
    }

    private File moveWavFileToDestinationDirectory(File file) throws IOException {
        File newWaveFileName = File.createTempFile("asa", ".wav", new File(wavStorageDir));
        file.renameTo(newWaveFileName);
        return newWaveFileName;
    }

    @PostConstruct
    private void readDir() {
        Properties properties = new Properties();
        try {
            URL resource = WaveFileStorageProcessor.class.getClassLoader().getResource("app.properties");
            String s = resource.getFile();
            File file = new File(s);
            properties.load(new FileInputStream(file));
            wavStorageDir = properties.getProperty("app.storagedir");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
