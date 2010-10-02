package com.callcenter.schedular;

import com.callcenter.external.WaveFileDirectoryPathFinder;
import com.callcenter.external.model.Directory;
import com.callcenter.external.model.File;
import com.callcenter.reader.WaveFileReader;
import com.callcenter.wavefile.processor.WaveFileProcessor;
import mockit.Mocked;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class CallRecordTaskSchedularTest {

    @Mocked
    private WaveFileDirectoryPathFinder waveFileDirectoryPathFinder;

    @Mocked
    private WaveFileReader waveFileReader;

    @Mocked
    private WaveFileProcessor waveFileProcessor;

    private CallRecordTaskSchedular schedular;


    @Before
    public void setUp() {
        schedular = new CallRecordTaskSchedular();
        schedular.setWaveFileDirectoryPathFinder(waveFileDirectoryPathFinder);
        schedular.setWaveFileProcessor(waveFileProcessor);
    }

    @Test
    public void shouldGetTheDirectoryPathAndProcessTheFileIfAnyFileIsAvailable(
            @NonStrict final Directory waveFileDirectory, @NonStrict final File file1, @NonStrict final File file2) {
        final List<File> files = new ArrayList<File>();
        files.add(file1);
        files.add(file2);
        new NonStrictExpectations() {
            {
                waveFileDirectoryPathFinder.getWaveFileDirectory();
                returns(waveFileDirectory);
                waveFileDirectory.list();
                returns(files);
            }
        };

        schedular.checkIfCallRecordAvailable();

        new Verifications() {
            {
                waveFileProcessor.process(file1);
                waveFileProcessor.process(file2);
            }
        };
    }
}
