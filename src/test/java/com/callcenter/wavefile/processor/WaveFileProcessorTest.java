package com.callcenter.wavefile.processor;

import com.callcenter.external.model.File;
import com.callcenter.reader.WaveFileReader;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
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

    @Before
    public void setUp() {
        waveFileProcessor = new WaveFileProcessor();
        waveFileProcessor.setWaveFileReader(waveFileReader);
    }

    @Test
    public void shouldProcessTheWaveFile(@NonStrict final File waveFile) {

        waveFileProcessor.process(waveFile);
        new VerificationsInOrder() {
            {
                waveFile.beforeProcess();
                waveFileReader.read(waveFile);
                waveFile.postProcess();
            }
        };
    }
}
