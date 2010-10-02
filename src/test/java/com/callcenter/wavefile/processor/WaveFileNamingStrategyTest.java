package com.callcenter.wavefile.processor;

import com.callcenter.util.ApplicationProperties;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileNamingStrategyTest {

    @Test
    public void shouldGetTheDirectoryPathWhereWeShouldMoveTheFilesFromAppProperties() throws IOException {
        final WaveFileNamingStrategy waveFileNamingStrategy = new WaveFileNamingStrategy();
        waveFileNamingStrategy.readDir();

        assertEquals(ApplicationProperties.getInstance().get("app.waveFile.storage.dir"),
                waveFileNamingStrategy.getWavStorageDir());
    }

    @Test
    public void shouldGetTheNewFileNameBasedOnTheCurrentDate() {
        final WaveFileNamingStrategy waveFileNamingStrategy = new WaveFileNamingStrategy();
        waveFileNamingStrategy.readDir();
        final String newFileName = waveFileNamingStrategy.generateNewFileName("HelloWave.wav");
        assertTrue(newFileName.startsWith(ApplicationProperties.getInstance().get("app.waveFile.storage.dir")));
        assertTrue(newFileName.endsWith("_HelloWave.wav"));
    }
}
