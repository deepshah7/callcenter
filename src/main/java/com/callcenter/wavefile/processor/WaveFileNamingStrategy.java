package com.callcenter.wavefile.processor;

import com.callcenter.util.ApplicationProperties;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WaveFileNamingStrategy {

    private String wavStorageDir;

    public String generateNewFileName(String originalFileName) {
            return wavStorageDir + "/" + new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())
                    + "_" + originalFileName;
    }

    public String getFullFilePath(String fileName) {
            return wavStorageDir + "/" + fileName;
    }

    @PostConstruct
    protected void readDir() {
        wavStorageDir = ApplicationProperties.getInstance().get("app.waveFile.storage.dir");
    }

    public String getWavStorageDir() {
        return wavStorageDir;
    }
}
