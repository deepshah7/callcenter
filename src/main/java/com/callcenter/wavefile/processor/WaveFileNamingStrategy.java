package com.callcenter.wavefile.processor;

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
    private static final Logger logger = Logger.getLogger(WaveFileNamingStrategy.class);

    private String wavStorageDir;

    public String generateNewFileName(String originalFileName) {
            return wavStorageDir + "/" + new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())
                    + "_" + originalFileName;
    }

    public String getFullFilePath(String fileName) {
            return wavStorageDir + "/" + fileName;
    }

    @PostConstruct
    private void readDir() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("app.properties").getInputStream());
            wavStorageDir = properties.getProperty("app.storagedir");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
