package com.callcenter.external.model;

import java.io.*;
import java.io.File;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.callcenter.domain.CallRecord;
import com.callcenter.wavefile.processor.WaveFileNamingStrategy;

@Component
public class ProcessedFile {
    private static final Logger logger = Logger.getLogger(WaveFileNamingStrategy.class);

    @Autowired
    WaveFileNamingStrategy waveFileNamingStrategy;

    public byte[] getProcessedWaveFileBuffer(Long callRecordId) {

        String waveFileName = getWaveFileFullPath(callRecordId);

        byte[] data = new byte[0];
        try {
            data = getFileData(waveFileName);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return data;
    }

    private String getWaveFileFullPath(Long callRecordId) {
        CallRecord callRecord = CallRecord.findCallRecord(callRecordId);
        String waveFileName = callRecord.getWavefilename();
        return waveFileName;
    }

    private byte[] getFileData(String waveFileName) throws Exception {
        String waveFile = waveFileNamingStrategy.getFullFilePath(waveFileName);
        java.io.File file = new File(waveFile);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        return buffer;
    }
}
