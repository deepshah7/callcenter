package com.callcenter.wavefile.processor;

import com.callcenter.external.model.File;
import com.callcenter.reader.WaveFileReader;
import mockit.NonStrict;
import mockit.VerificationsInOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileProcessorTest {

    private WaveFileProcessor waveFileProcessor;

    @NonStrict
    private WaveFileReader waveFileReader;
    @NonStrict
    private WaveFileNamingStrategy waveFileNamingStrategy;

    @Before
    public void setUp() {
        waveFileProcessor = new WaveFileProcessor();
        waveFileProcessor.setWaveFileReader(waveFileReader);
        waveFileProcessor.setWaveFileNamingStrategy(waveFileNamingStrategy);
    }

    @Test
    public void shouldProcessTheWaveFile(@NonStrict final File waveFile) {

        waveFileProcessor.process(waveFile);
        new VerificationsInOrder() {
            {
                waveFile.beforeProcess(waveFileNamingStrategy);
                waveFileReader.read(waveFile);
                waveFile.postProcess();
            }
        };
    }
}
