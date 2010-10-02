package com.callcenter.wavefile.processor;

import mockit.NonStrict;
import mockit.NonStrictExpectations;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileNamingStrategyTest {

    @Test
    @Ignore("TODO : get the file path from the app.properties file")
    public void shouldGetTheDirectoryPathWhereWeShouldMoveTheFilesFromAppProperties() throws IOException {
        final WaveFileNamingStrategy waveFileNamingStrategy = new WaveFileNamingStrategy();
        waveFileNamingStrategy.readDir();

        assertEquals("E:/playground/projarea/java/docs/callcenter/processed", waveFileNamingStrategy.getWavStorageDir());
    }

    @Test
    @Ignore("TODO : get the file path from the app.properties file")
    public void shouldGetTheNewFileNameBasedOnTheCurrentDate() {
        final WaveFileNamingStrategy waveFileNamingStrategy = new WaveFileNamingStrategy();
        waveFileNamingStrategy.readDir();
        final String newFileName = waveFileNamingStrategy.generateNewFileName("HelloWave.wav");
        assertTrue(newFileName.startsWith("E:/playground/projarea/java/docs/callcenter/processed/"));
        assertTrue(newFileName.endsWith("_HelloWave.wav"));
    }
}
