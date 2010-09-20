package com.callcenter.schedular;

import com.callcenter.external.WaveFileDirectoryPathFinder;
import com.callcenter.reader.WaveFileReader;
import mockit.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;

import static junit.framework.Assert.assertEquals;

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

    private CallRecordTaskSchedular schedular;


    @Before
    public void setUp() {
        schedular = new CallRecordTaskSchedular();
        schedular.setWaveFileDirectoryPathFinder(waveFileDirectoryPathFinder);
        schedular.setWaveFileReader(waveFileReader);
    }
    
    @Test
    public void shouldGetTheDirectoryPathAndProcessTheFileIfAnyFileIsAvailable(
            @NonStrict final File waveFileDirectory) {
        new NonStrictExpectations() {
            {
                waveFileDirectoryPathFinder.getWaveFileDirectory(); returns("HelloWaveFilePath");
                new File("HelloWaveFilePath");

                waveFileDirectory.isDirectory(); returns(true);

                waveFileDirectory.list(); returns(new String[] {"file1", "file2"});

                new File("file1");
                new File("file2");
            }
        };

        schedular.checkIfCallRecordAvailable();

        new Verifications() {
            {
                waveFileReader.read((File) withNotNull()); times=2;
            }
        };
    }
    
    @Test
    public void shouldNotDoAnythingIfTheDirectoryPathPointsToAFile(@NonStrict final File waveFileDirectory) {
        new NonStrictExpectations() {
            {
                waveFileDirectoryPathFinder.getWaveFileDirectory(); returns("HelloWaveFilePath");
                new File("HelloWaveFilePath");

                waveFileDirectory.isDirectory(); returns(false);
            }
        };

        schedular.checkIfCallRecordAvailable();

        new Verifications() {
            {
                waveFileDirectory.list(); times = 0;
                waveFileReader.read((File) withNotNull()); times=0;
            }
        };
    }

}
